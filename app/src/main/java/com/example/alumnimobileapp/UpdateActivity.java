package com.example.alumnimobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.ProgressDialog;

import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateActivity extends AppCompatActivity {

    public static final String URL = "https://gpa-alumni.000webhostapp.com/";
    private ProgressDialog progress;

    @BindView(R.id.editTextNama) EditText editTextNama;
    @BindView(R.id.editTextAngkatan) EditText editTextAngkatan;
    @BindView(R.id.editTextHP) EditText editTextHP;
    @BindView(R.id.editTextEmail) EditText editTextEmail;

    @OnClick(R.id.buttonUbah) void update() {
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        String nama = editTextNama.getText().toString();
        String angkatan = editTextAngkatan.getText().toString();
        String no_hp = editTextHP.getText().toString();
        String email = editTextEmail.getText().toString();

        if (isEmailValid(email) && isPhoneNumberValid(no_hp)) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RegisterAPI api = retrofit.create(RegisterAPI.class);
            Call<Value> call = api.update(nama, angkatan, no_hp, email);

            call.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    String value = response.body().getValue();
                    String message = response.body().getMessage();
                    progress.dismiss();
                    if (value.equals("1")) {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Value> call, Throwable t) {
                    progress.dismiss();
                    Toast.makeText(UpdateActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
                }
            });

        } else if ((isEmailValid(email) == false) && isPhoneNumberValid(no_hp)){
            progress.dismiss();
            Toast.makeText(UpdateActivity.this, "Format Email Salah", Toast.LENGTH_SHORT).show();
        } else if (isEmailValid(email)  && (isPhoneNumberValid(no_hp) == false)){
            progress.dismiss();
            Toast.makeText(UpdateActivity.this, "Format Nomor HP Salah", Toast.LENGTH_SHORT).show();
        } else if ((isEmailValid(email) == false) && (isPhoneNumberValid(no_hp) == false)){
            progress.dismiss();
            Toast.makeText(UpdateActivity.this, "Format Email dan Nomor HP Salah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Update Data");

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String angkatan = intent.getStringExtra("angkatan");
        String no_hp = intent.getStringExtra("no_hp");
        String email = intent.getStringExtra("email");

        editTextNama.setText(nama);
        editTextAngkatan.setText(angkatan);
        editTextHP.setText(no_hp);
        editTextEmail.setText(email);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean isEmailValid(String email){
        String regexExpression =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regexExpression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }

    public boolean isPhoneNumberValid(String number)
    {
        return android.util.Patterns.PHONE.matcher(number).matches();
    }

}