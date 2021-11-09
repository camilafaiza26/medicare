package com.example.medicare.zonacovid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

    @GET("indonesia")
    Call<List<GetDataCovid>> getDatas();
}
