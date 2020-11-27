package com.example.alumnimobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainPage extends AppCompatActivity {

    @OnClick(R.id.buttonDaftar) void daftar() {
        startActivity(new Intent(MainPage.this, RegisterActivity.class));
    }

    @OnClick(R.id.buttonLihat) void lihat() {
        startActivity(new Intent(MainPage.this, ViewActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        ButterKnife.bind(this);
    }
}