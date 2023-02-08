package com.example.onnuwhere;


import com.example.onnuwhere.model.ResultSearchKeyword;

import com.example.onnuwhere.model.firstpage.Document;
import com.example.onnuwhere.model.firstpage.InitLoc;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface KakaoService {
    @GET("v2/local/search/keyword.json")
    Call<ResultSearchKeyword>  getSearchKeyword(
            @Header("Authorization") String key, @Query("query") String query
            ,@Query("y") String y, @Query("x") String x,
             @Query("size") int size);

    @GET("v2/local/geo/coord2address.json")
    Call<Document> getXY(
            @Header("Authorization") String key
            ,@Query("x") String x, @Query("y") String y);

}
