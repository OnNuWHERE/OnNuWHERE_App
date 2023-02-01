package com.example.onnuwhere;

import com.example.onnuwhere.model.ResultSearchKeyword;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface KakaoService {
    @GET("https://dapi.kakao.com/v2/local/search/keyword.json")
    public List<ResultSearchKeyword> getSearchKeyword(
            @Header("Authorization") String key, @Query("query") String query);
}
