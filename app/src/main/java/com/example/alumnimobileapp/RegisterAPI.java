package com.example.alumnimobileapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class RegisterAPI {

    @FormUrlEncoded
    @POST("/insert.php")
    Call<Value> daftar(@Field("Nama") String nama,
                       @Field("Angkatan") String angkatan,
                       @Field("Nomor_HP") String no_hp,
                       @Field("Email") String email)

}
