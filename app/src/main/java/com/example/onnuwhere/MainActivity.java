package com.example.onnuwhere;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.onnuwhere.model.Place;
import com.example.onnuwhere.model.ResultSearchKeyword;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.nio.file.Files;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MapView.CurrentLocationEventListener, MapView.MapViewEventListener {

    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION};
    Toolbar toolbar;
    ActionBar actionBar;
    Button searchBtn, btnAED, btnCivil, btnDisaster,btnCpos;
    EditText searchEdt;
    MapPoint.GeoCoordinate mPointGeo;
    MapPoint currentMapPoint;
    String keyword;
    RecyclerView recyclerView;

    private KakaoService kakaoService;

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
        searchEdt = (EditText) findViewById(R.id.searchEdt);
        searchBtn = (Button) findViewById(R.id.searchBtn);


        btnAED = (Button) findViewById(R.id.btnAED);
        btnCivil = (Button) findViewById(R.id.btnCivil);
        btnDisaster = (Button) findViewById(R.id.btnDisaster);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


       final MapView mView = new MapView(MainActivity.this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mView);
        mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
        mView.setMapViewEventListener(this);
        if(!checkLocationServiceStatus()){
            showDialogForGpsServiceSetting();
        }else {
            checkRunTimePermission();
        }

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               keyword = searchEdt.getText().toString();
               searchKeyword(keyword);
            }
        });

        btnCpos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("@@@","TrackingMode : "+mView.getCurrentLocationTrackingMode());
                if(mView.getCurrentLocationTrackingMode()==MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading){
                    Toast.makeText(MainActivity.this, "nonHeading", Toast.LENGTH_SHORT).show();
                    mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
                }else if (mView.getCurrentLocationTrackingMode()==MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading){
                    Toast.makeText(MainActivity.this, "Heading", Toast.LENGTH_SHORT).show();
                    mView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
                }else {
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
        Log.d("@@@@", "x:"+ mPointGeo.latitude+"y:"+ mPointGeo.longitude+"f:"+ v);
        currentMapPoint = MapPoint.mapPointWithGeoCoord(mPointGeo.latitude, mPointGeo.longitude);
        mapView.setMapCenterPoint(currentMapPoint, true);
    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

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
        if(requestCode==100 && grantResults.length==REQUIRED_PERMISSIONS.length){
            boolean check_result = true;

            for (int result : grantResults){
                if(result != PackageManager.PERMISSION_GRANTED){
                    check_result = false;
                }
            }
            if(check_result){
                Log.d("@@@", "start");
            }else if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])){
                Toast.makeText(this, "Reject Permission", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                Toast.makeText(this, "reject Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void checkRunTimePermission(){
        //런타임 퍼미션 처리
        //1. 위치 퍼미션을 가지고 있는지 확인
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if(hasFineLocationPermission == PackageManager.PERMISSION_GRANTED){
            //이미 가지고 있다면 위치값을 가지고 올 수 있음
        }else{
            //퍼미션 허용 x 시 요청이 필요함
            ActivityCompat.requestPermissions(MainActivity.this, REQUIRED_PERMISSIONS, 100);
        }
    }

    private void  showDialogForGpsServiceSetting(){
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

        switch (requestCode){
            case 2001: if(checkLocationServiceStatus()){
                Log.d("@@@","활성화");
                checkRunTimePermission();
                return;
            }
            break;
        }
    }

    public boolean checkLocationServiceStatus(){
       LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
       return  locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
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
        Toast.makeText(this, "end", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {
        Toast.makeText(this, "fin", Toast.LENGTH_SHORT).show();

    }


    public void searchKeyword(String keyword) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        kakaoService = retrofit.create(KakaoService.class);
        Call<ResultSearchKeyword> call =
                kakaoService.getSearchKeyword("KakaoAK be98ca85a3689bc0780a8f0f28b977c7", keyword);
        call.enqueue(new Callback<ResultSearchKeyword>() {
            @Override
            public void onResponse(Call<ResultSearchKeyword> call, Response<ResultSearchKeyword> response) {
                Log.d("tag", response.toString()+"");
            }

            @Override
            public void onFailure(Call<ResultSearchKeyword> call, Throwable t) {
                Log.d("FAIL",t.toString()+"");
            }
        });
    }

}