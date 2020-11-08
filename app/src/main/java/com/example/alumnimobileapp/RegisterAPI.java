package com.example.alumnimobileapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(@Field("nama") String nama,
                       @Field("angkatan") String angkatan,
                       @Field("no_hp") String no_hp,
                       @Field("email") String email);

    @GET("read.php")
    Call<Value> view();

    @FormUrlEncoded
    @POST("update.php")
    Call<Value> update(@Field("nama") String nama,
                       @Field("angkatan") String angkatan,
                       @Field("no_hp") String no_hp,
                       @Field("email") String email);

    @FormUrlEncoded
    @POST("search.php")
    Call<Value> search(@Field("search") String search);
}
