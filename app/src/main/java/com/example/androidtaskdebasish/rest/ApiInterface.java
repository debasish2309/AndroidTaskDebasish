package com.example.androidtaskdebasish.rest;

import com.example.androidtaskdebasish.model.DataClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers({"Accept: application/json"})
    @GET("customsearch/v1")
    Call<DataClass> getImages(
                     @Query("q") String q ,
                     @Query("cx") String cx ,
                     @Query("key") String key,
                     @Query("searchType") String searchType);
}
