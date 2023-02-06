package com.example.onnuwhere;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.onnuwhere.Controller.AEDDAO;
import com.example.onnuwhere.model.AED;
import com.example.onnuwhere.model.Civil;
import com.example.onnuwhere.model.ResultSearchKeyword;
import com.example.onnuwhere.model.TsunamiShelter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MapView.CurrentLocationEventListener, MapView.MapViewEventListener {


    public static Context mContext;
    Location location;


    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION};
    Toolbar toolbar;
    ActionBar actionBar;
    Button searchBtn, btnAED, btnCivil, btnDisaster, btnCpos;
    MapPoint.GeoCoordinate mPointGeo;
    MapPoint currentMapPoint;
    RecyclerView recyclerView;

    private KakaoService kakaoService;
    LinearLayoutManager manager;
    MapView mView;

    FirebaseDatabase database;
    String address;
    String[] gugun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getHashKey();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        btnCpos = (Button) findViewById(R.id.btnCpos);
        searchBtn = (Button) findViewById(R.id.searchBtn);


        btnAED = (Button) findViewById(R.id.btnAED);
        btnCivil = (Button) findViewById(R.id.btnCivil);
        btnDisaster = (Button) findViewById(R.id.btnDisaster);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mView = new MapView(MainActivity.this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mView);
        mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
        mView.setMapViewEventListener(this);
        if (!checkLocationServiceStatus()) {
            showDialogForGpsServiceSetting();
        } else {
            checkRunTimePermission();
        }

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                                PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                if (lm.getLastKnownLocation(LocationManager.GPS_PROVIDER) != null) {
                    location = (Location) lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                } else {
                    location = (Location) lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }
                Intent searchIntent = new Intent(MainActivity.this, Search_View.class);
                startActivityForResult(searchIntent, 1);

            }
        });

        btnCpos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("@@@", "TrackingMode : " + mView.getCurrentLocationTrackingMode());
                if (mView.getCurrentLocationTrackingMode() == MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading) {
                    Toast.makeText(MainActivity.this, "nonHeading", Toast.LENGTH_SHORT).show();
                    mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
                } else if (mView.getCurrentLocationTrackingMode() == MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading) {
                    Toast.makeText(MainActivity.this, "Heading", Toast.LENGTH_SHORT).show();
                    mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
                } else {
                    Toast.makeText(MainActivity.this, "mHeading", Toast.LENGTH_SHORT).show();
                    mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
                }
            }
        });

    }
//
//    private void getHashKey() {
//        PackageInfo packageInfo = null;
//        try {
//            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (packageInfo == null)
//            Log.e("KeyHash", "KeyHash:null");
//
//        for (Signature signature : packageInfo.signatures) {
//            try {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            } catch (NoSuchAlgorithmException e) {
//                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
//            }
//        }
//    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {
        mPointGeo = mapPoint.getMapPointGeoCoord();

        Log.d("@@@@", "x:" + mPointGeo.latitude + "y:" + mPointGeo.longitude + "f:" + v);
        currentMapPoint = MapPoint.mapPointWithGeoCoord(mPointGeo.latitude, mPointGeo.longitude);
        mapView.setMapCenterPoint(currentMapPoint, true);

    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {
        TsunamiSearch(mPointGeo.latitude, mPointGeo.longitude);

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length == REQUIRED_PERMISSIONS.length) {
            boolean check_result = true;

            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                }
            }
            if (check_result) {
                Log.d("@@@", "start");
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {
                Toast.makeText(this, "Reject Permission", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "reject Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void checkRunTimePermission() {
        //런타임 퍼미션 처리
        //1. 위치 퍼미션을 가지고 있는지 확인
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED) {
            //이미 가지고 있다면 위치값을 가지고 올 수 있음
        } else {
            //퍼미션 허용 x 시 요청이 필요함
            ActivityCompat.requestPermissions(MainActivity.this, REQUIRED_PERMISSIONS, 100);
        }
    }

    private void showDialogForGpsServiceSetting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n" + "위치 설정을 수정하시겠습니까?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent callGpsSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGpsSettingIntent, 2001);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 2001:
                if (checkLocationServiceStatus()) {
                    Log.d("@@@", "활성화");
                    checkRunTimePermission();
                    return;
                }
                break;

            case 1: {
                if (resultCode == RESULT_OK) {
                    Toast.makeText(MainActivity.this, "@@@ " + resultCode, Toast.LENGTH_SHORT).show();

                    Intent markerIntent = data;
                    Log.d("2@@@", markerIntent + "");

                    double sLat = Double.parseDouble(markerIntent.getStringExtra("y"));
                    double sLong = Double.parseDouble(markerIntent.getStringExtra("x"));
                    address = markerIntent.getStringExtra("address_name");
                    gugun = address.split(" ");

                    //마커 표시
                    MapPOIItem marker = new MapPOIItem();
                    marker.setItemName(markerIntent.getStringExtra("placeName"));
                    marker.setTag(Integer.parseInt(markerIntent.getStringExtra("ID")));
                    marker.setMapPoint(MapPoint.mapPointWithGeoCoord(sLat, sLong));
                    marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mView.addPOIItem(marker);

                    //중심점 변경
                    mView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(sLat, sLong), true);
                    //TrackingModeOff
                    mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
                    //firebase 연결 후 주변 300m 만 마커 표시 그 외에는 마커에서 제외
                    //마커 사용시 커스텀 마커 사용
                    Toast.makeText(MainActivity.this, "에러" + resultCode, Toast.LENGTH_SHORT).show();
                    TsunamiSearch(sLong,sLat);

//                    AEDDAO adao = new AEDDAO();



                } else {
                    Toast.makeText(MainActivity.this, "에러" + resultCode, Toast.LENGTH_SHORT).show();
                }


            }

        }
    }

    public boolean checkLocationServiceStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {
        Toast.makeText(this, "zoom", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {
        Toast.makeText(this, "tap", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {
        Toast.makeText(this, "double", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {
        Toast.makeText(this, "long", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {
        Toast.makeText(this, "drag", Toast.LENGTH_SHORT).show();
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {
    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    private void TsunamiSearch(double x, double y) {

        database = FirebaseDatabase
                .getInstance("https://onnuwhere-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference refTsunami =
                database.getReference("TsunamiShelter");
        ArrayList<TsunamiShelter> TsunamiList = new ArrayList<>();

//        refTsunami.orderByChild("sigungu_name").equalTo(gugun[1]).addValueEventListener(new ValueEventListener() {
        refTsunami.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TsunamiList.clear();
                List<MapPOIItem> mapPOIItemList = new ArrayList<>();
                int index = 0;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    TsunamiShelter TsunamiData = dataSnapshot.getValue(TsunamiShelter.class);
                    TsunamiList.add(TsunamiData);
//                                for (int i = 0; i < TsunamiList.size(); i++) {
                    double lat = TsunamiList.get(index).getLat();
                    double lon = TsunamiList.get(index).getLon();
                    MapPOIItem mapPOIItem = new MapPOIItem();
                    double calDis = distance(lat, lon, y, x, "K");
                    mapPOIItem.setItemName(TsunamiList.get(index).getShel_nm());
                    mapPOIItem.setTag(Long.valueOf(TsunamiList.get(index).getId()).intValue());
                    mapPOIItem.setMapPoint(MapPoint.mapPointWithGeoCoord(lat, lon));
                    mapPOIItem.setMarkerType(MapPOIItem.MarkerType.RedPin);
//                                        mapPOIItem.setCustomImageResourceId(R.drawable.aed_location);
//                                        mapPOIItem.isCustomImageAutoscale();

                    if (calDis * 1000 <= 1000000) {
                        mapPOIItemList.add(mapPOIItem);
                    }
//                                }
                    index++;
                }
                mView.addPOIItems(mapPOIItemList.toArray(new MapPOIItem[mapPOIItemList.size()]));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (Math.round(Math.abs(dist)));
        }
    }

}