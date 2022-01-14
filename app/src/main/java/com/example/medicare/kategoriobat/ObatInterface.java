package com.example.medicare.kategoriobat;

import com.example.medicare.data.model.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ObatInterface {

    @GET("getobat")
    Call<Kategori_Obat> getObat(
    );
}
