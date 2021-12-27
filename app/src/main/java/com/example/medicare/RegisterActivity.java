package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.medicare.API.ApiClient;
import com.example.medicare.register.ApiInterface;
import com.example.medicare.register.model.Data;
import com.example.medicare.register.model.Register;
import com.example.medicare.ui.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements  View.OnClickListener {

    EditText etName, etPhone, etEmail, etPassword;
    Button btnRegister;
    String Email, Password, Name, Phone;
    ApiInterface apiInterface;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ImageButton backregister = findViewById(R.id.backButton);
        backregister.setOnClickListener(this);

        btnRegister = findViewById(R.id.btnregister);
        btnRegister.setOnClickListener(this);

        etName = findViewById(R.id.name);
        etEmail = findViewById(R.id.emailR);
        etPhone = findViewById(R.id.phone);
        etPassword = findViewById(R.id.passwordR);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton:
                Intent registerIntent = new Intent(RegisterActivity.this, Onboarding.class);
                startActivity(registerIntent);
                finish();
                break;
            case R.id.btnregister:
                Name = etName.getText().toString();
                Email = etEmail.getText().toString();
                Phone = etPhone.getText().toString();
                Password = etPassword.getText().toString();
                register(Name, Email, Phone, Password);
                break;
        }
    }

    private void register(String name, String email, String phone, String password) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Register> call = apiInterface.registerResponse(name,email,phone,password);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.body() != null) {

                    // Ini untuk menyimpan sesi
                    sessionManager = new SessionManager(RegisterActivity.this);
                    Data registerData = response.body().getData();
                    sessionManager.createRegisSession(registerData);

                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("user_name", Name);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Gagal Register, Cek Inputan Kembali!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}