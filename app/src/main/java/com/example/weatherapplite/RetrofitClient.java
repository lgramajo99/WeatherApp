package com.example.weatherapplite;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private API myApi;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi = retrofit.create(API.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public API getMyApi() {
        return myApi;
    }
}
