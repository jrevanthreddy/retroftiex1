package com.example.retrofitex1.serviceapi;

import com.example.retrofitex1.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<Result> getMovie(@Query("api_key") String apiKey);
}
