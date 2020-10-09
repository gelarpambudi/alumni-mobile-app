package com.example.alumnimobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://gpa-alumni.000webhostapp.com/";
    private ProgressDialog progress;

    @BindView(R.id.editTextNama) EditText editTextNama;
    @BindView(R.id.editTextAngkatan) EditText editTextAngkatan;
    @BindView(R.id.editTextHP) EditText editTextHP;
    @BindView(R.id.editTextEmail) EditText editTextEmail;

    @OnClick(R.id.buttonDaftar) void daftar() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}