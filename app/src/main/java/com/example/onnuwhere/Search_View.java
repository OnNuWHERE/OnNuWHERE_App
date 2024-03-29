package com.example.onnuwhere;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.Place;
import com.example.onnuwhere.model.ResultSearchKeyword;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Search_View extends Activity {

    Button btnReturn, btnSearch;
    EditText searchEdt;
    RecyclerView recyclerView;

    private KakaoService kakaoService;
    LinearLayoutManager manager;

    public static Context mContext;

    Location location;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        searchEdt = (EditText) findViewById(R.id.searchEdt);
        recyclerView = (RecyclerView) findViewById(R.id.ResultRecyclerView);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchEdt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    searchEdt.setText(searchEdt.getText().toString());
                    btnSearch.callOnClick();
                }
                return false;
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchEdt.getText().toString();
                searchKeyword(search);
            }
        });

    }

    public void searchKeyword(String keyword) {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(Search_View.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Search_View.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (lm.getLastKnownLocation(LocationManager.GPS_PROVIDER) != null) {
            location = (Location) lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } else {
            location = (Location) lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        String apiKey = "KakaoAK 091bdc2aa5e0e18b40a1fab4607866e8";
        kakaoService = retrofit.create(KakaoService.class);

        Call<ResultSearchKeyword> call =
                kakaoService.getSearchKeyword(apiKey, keyword, String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), 15, "distance");
        call.enqueue(new Callback<ResultSearchKeyword>() {
            @Override
            public void onResponse(Call<ResultSearchKeyword> call, Response<ResultSearchKeyword> response) {
                Log.d("success", "" + response.toString());

                mContext = Search_View.this;
                manager = new LinearLayoutManager(Search_View.this,
                        RecyclerView.VERTICAL, false);
                ResultSearchKeyword resultSearchKeyword = response.body();
                SearchAddrAdapter adapter = new SearchAddrAdapter(resultSearchKeyword.getDocuments());
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);

                adapter.setSearchListener(new SearchListener() {
                    @Override
                    public void SearchItemClick(int position) {
                        Place p = adapter.getItem(position);
                        Intent intent_marker = new Intent(Search_View.this, MainActivity.class);
                        intent_marker.putExtra("x", p.getX());
                        intent_marker.putExtra("y", p.getY());
                        intent_marker.putExtra("placeName", p.getPlace_name());
                        intent_marker.putExtra("ID", p.getId());
                        intent_marker.putExtra("address_name", p.getAddress_name());
                        setResult(RESULT_OK, intent_marker);
                        finish();
                    }
                });
            }


            @Override
            public void onFailure(Call<ResultSearchKeyword> call, Throwable t) {
                Log.d("%%%", "" + t.toString());
            }
        });
    }
}
