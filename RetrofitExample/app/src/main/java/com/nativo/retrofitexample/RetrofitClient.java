package com.nativo.retrofitexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance = null;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private RetrofitClient(){};

    public static Retrofit getInstance(){
        if(instance == null){
          instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // url base da api
                    .addConverterFactory(GsonConverterFactory.create()) // conversor de json para objeto
                    .build();
        }
        return instance;
    }
}
