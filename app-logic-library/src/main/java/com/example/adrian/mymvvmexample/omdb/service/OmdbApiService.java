package com.example.adrian.mymvvmexample.omdb.service;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

public interface OmdbApiService {

    public static final String BASE_URL = "http://www.omdbapi.com/";

    @GET("/")
    Call<String> findAllMovie();

    @GET("/")
    Call<String> findMovieByYear(@QueryMap Map<String, Integer> options);

    @GET("/")
    Call<String> findMovieByTitle(@QueryMap Map<String, String> options);

}

