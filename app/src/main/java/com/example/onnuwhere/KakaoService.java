package com.example.onnuwhere;

import com.example.onnuwhere.model.Place;
import com.example.onnuwhere.model.ResultSearchKeyword;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface KakaoService {
    @GET("v2/local/search/keyword.json")
    Call<ResultSearchKeyword>  getSearchKeyword(
            @Header("Authorization") String key, @Query("query") String query
            ,@Query("y") String y, @Query("x") String x,
            @Query("page") int page, @Query("size") int size, @Query("sort") String distance);
}
