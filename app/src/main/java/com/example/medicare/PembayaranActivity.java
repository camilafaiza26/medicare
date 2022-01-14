package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PembayaranActivity extends AppCompatActivity implements  View.OnClickListener {

    TextView alamatNya, namaNya;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        String current = getIntent().getStringExtra("CURRENT_LOCATION2");
        alamatNya = findViewById(R.id.alamatNya);
        alamatNya.setText(current);

        namaNya = findViewById(R.id.namaNya);

        sessionManager = new SessionManager(PembayaranActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        String nama = sessionManager.getUserDetail().get(SessionManager.NAME);
        String nohp = sessionManager.getUserDetail().get(SessionManager.PHONE);

        namaNya.setText(nama + "|" + nohp);

        ImageButton toCheckoutObat = findViewById(R.id.backButton5);
        toCheckoutObat.setOnClickListener(this);
    }

    private void moveToLogin() {
        Intent toLogin = new Intent(PembayaranActivity.this, Onboarding.class);
        toLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(toLogin);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backButton5:
                Intent toCheckoutIntent = new Intent(PembayaranActivity.this, Checkout.class);
                startActivity(toCheckoutIntent);
                break;

        }
    }
}