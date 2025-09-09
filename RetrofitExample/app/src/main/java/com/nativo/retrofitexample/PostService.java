package com.nativo.retrofitexample;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PostService {

    @GET("/posts") // chamada do metodo com o endpoint
    Call<List<PostEntity>> getPosts(); // um call back com retorno de uma lista do tipo PostEntity
}
