package com.devmasterteam.tasks.service.repository;

import android.util.Log;

import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.remote.PersonService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonRepository {
    private PersonService personService;

    public PersonRepository() {
        this.personService = RetrofitClient.createService(PersonService.class);
    }

    public void create(String name, String email, String password) {
        Call<PersonModel> call = this.personService.create(name, email, password);
        call.enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
               PersonModel p = response.body();
               int code = response.code();
                Log.d("RETROFIT", "code: " + code + "body: " + p);

               response.errorBody();
            }

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {

            }
        });
    }
}
