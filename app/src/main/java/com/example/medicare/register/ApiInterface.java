package com.example.medicare.register;

import com.example.medicare.register.model.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register")
    Call<Register> registerResponse(

            @Field("name") String name,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("password") String password
    );
}
