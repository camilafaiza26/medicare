package com.example.medicare.data;

import com.example.medicare.data.model.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("login")
    Call<Login> loginResponse(

            @Field("email") String email,
            @Field("password") String password
            );
}
