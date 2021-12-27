package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.medicare.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity  implements  View.OnClickListener {


    BottomNavigationView bottomNavigationView;
    ImageButton backbutton2;
    ImageButton toEdit;
    Button logout;
    SessionManager sessionManager;
    TextView pronama, proemail, prophone;
    String nama, phone, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(ProfileActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }


        pronama = findViewById(R.id.pronama);
        nama = sessionManager.getUserDetail().get(SessionManager.NAME);
        pronama.setText(nama);

        proemail = findViewById(R.id.proEmail);
        email = sessionManager.getUserDetail().get(SessionManager.EMAIL);
        proemail.setText(email);

        prophone = findViewById(R.id.prophone);
        phone = sessionManager.getUserDetail().get(SessionManager.PHONE);
        prophone.setText(phone);



        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        toEdit = findViewById(R.id.imageButton2);
       toEdit.setOnClickListener(this);

        backbutton2 = findViewById(R.id.backButton2);
        backbutton2.setOnClickListener(this);
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(this);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beranda:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                    case R.id.transaksi:
                        startActivity(new Intent(getApplicationContext(), RiwayatTransaksiActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        return true;
                    case R.id.jadwal:
                        startActivity(new Intent(getApplicationContext(), JadwalObatActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.telepon:
                        startActivity(new Intent(getApplicationContext(), TenagaMedisActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return true;
            }

        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton2:
                Intent profilIntent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(profilIntent);
                break;
            case R.id.logout:
                sessionManager.logoutSession();
                moveToLogin();

                break;
            case R.id.imageButton2:
                Intent toEditIntent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(toEditIntent);
                break;
        }
    }

    private void moveToLogin() {
        Intent toLogin = new Intent(ProfileActivity.this, Onboarding.class);
        toLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(toLogin);
        finish();
    }

}