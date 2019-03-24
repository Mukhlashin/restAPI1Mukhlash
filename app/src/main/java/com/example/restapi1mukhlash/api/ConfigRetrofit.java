package com.example.restapi1mukhlash.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static String url = "https://www.thesportsdb.com/api/v1/json/1/";

    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    public static Retrofit setInit2() {
//        return new Retrofit.Builder().baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }

    public static APIService getInstance() {
        return setInit().create(APIService.class);

    }

//    public static APIService getInstance2() {
//        return setInit2().create(APIService.class);
//    }
}
