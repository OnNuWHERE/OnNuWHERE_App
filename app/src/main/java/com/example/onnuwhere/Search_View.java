package com.example.onnuwhere;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        searchEdt = (EditText) findViewById(R.id.searchEdt);
        recyclerView = (RecyclerView) findViewById(R.id.ResultRecyclerView);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchEdt.getText().toString();
                searchKeyword(search);
            }
        });

    }

    public void searchKeyword(String keyword) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        String apiKey = "KakaoAK 091bdc2aa5e0e18b40a1fab4607866e8";
        kakaoService = retrofit.create(KakaoService.class);
        Call<ResultSearchKeyword> call =
                kakaoService.getSearchKeyword(apiKey, keyword);
        call.enqueue(new Callback<ResultSearchKeyword>() {
            @Override
            public void onResponse(Call<ResultSearchKeyword> call, Response<ResultSearchKeyword> response) {
                manager = new LinearLayoutManager(Search_View.this,
                        RecyclerView.VERTICAL, false);
                ResultSearchKeyword resultSearchKeyword = response.body();
                SearchAddrAdapter adapter = new SearchAddrAdapter(resultSearchKeyword.getDocuments());
                Intent intent = getIntent();
                Double lat1 = intent.getDoubleExtra("lat",0);
                Double lon1 = intent.getDoubleExtra("long",0);
                adapter.calLocation(lat1,lon1);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResultSearchKeyword> call, Throwable t) {
                Log.d("%%%", ""+t.toString());
            }
        });
    }
}
