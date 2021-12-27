package com.example.medicare.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medicare.API.ApiClient;
import com.example.medicare.MainActivity;
import com.example.medicare.Onboarding;
import com.example.medicare.R;
import com.example.medicare.SessionManager;
import com.example.medicare.data.LoginInterface;
import com.example.medicare.data.model.Login;
import com.example.medicare.data.model.Data;
import com.example.medicare.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener{

    private ActivityLoginBinding binding;
    Button btnLogin;
    EditText etEmail, etPassword;
    String Email, Password;
    LoginInterface loginInterface;
    SessionManager sessionManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        binding = ActivityLoginBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//
//        final EditText usernameEditText = binding.username;
//        final EditText passwordEditText = binding.password;
//        final Button loginButton = binding.login;
//        final ProgressBar loadingProgressBar = binding.loading;

        etEmail = findViewById(R.id.txtemail);
        etPassword = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()) {
                case R.id.arrowButton:
                    Intent loginIntent = new Intent(LoginActivity.this, Onboarding.class);
                    startActivity(loginIntent);
                    break;
                case R.id.btnlogin:
                    Email = etEmail.getText().toString();
                    Password = etPassword.getText().toString();
                    login(Email,Password);
                    break;
            }
    }

    private void login(String email, String password) {

        loginInterface = ApiClient.getClient().create(LoginInterface.class);
        Call<Login> loginCall = loginInterface.loginResponse(email,password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body() != null){
                    Login login = response.body();
                    Data data = login.getData();
                    String token = data.getToken();
                    String email = data.getEmail();
                    String name = data.getName();
                    String phone = data.getPhone();

                    // Ini untuk menyimpan sesi
                    sessionManager = new SessionManager(LoginActivity.this);
                    Data loginData = response.body().getData();
                    sessionManager.createLoginSession(loginData);

                    //Ini untuk pindah
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Gagal Login", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}