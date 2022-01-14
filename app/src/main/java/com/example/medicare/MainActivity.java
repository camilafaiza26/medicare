package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.medicare.ui.login.LoginActivity;
import com.example.medicare.zonacovid.GetDataCovid;
import com.example.medicare.zonacovid.JsonPlaceHolderAPI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  implements  View.OnClickListener {

    BottomNavigationView bottomNavigationView;
    private TextView datacovidResultMeninggal;
    private TextView datacovidResultPositif;
    private TextView datacovidResultSembuh;

    private TextView messageAPI;
    private ImageButton treatmentButton;
    SessionManager sessionManager;

    ImageView profileFoto;
    TextView txthaloNama;
    String haloNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }


        txthaloNama = findViewById(R.id.nameUserHome);
        haloNama = sessionManager.getUserDetail().get(SessionManager.NAME);
        txthaloNama.setText(haloNama);


        profileFoto = findViewById(R.id.profileFoto);
        if(sessionManager.getUserDetail().get(SessionManager.IMAGE)==null){

        }
        else{
            String url = "https://medicareapii.herokuapp.com/";
            String urlImageg = sessionManager.getUserDetail().get(SessionManager.IMAGE);
            String urlImage = urlImageg.substring(7);

            Glide.with(this)
                    .load(url + urlImage)
                    .into(profileFoto);
        }


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        ImageButton toZonaCovid= findViewById(R.id.btn_menu1_1);
        toZonaCovid.setOnClickListener(this);

        ImageButton treatmentButton= findViewById(R.id.btn_menu1_3);
        treatmentButton.setOnClickListener(this);

        ImageButton beritaButton= findViewById(R.id.btn_menu1_2);
        beritaButton.setOnClickListener(this);

        ImageButton jadwalButton= findViewById(R.id.btn_menu2_2);
        jadwalButton.setOnClickListener(this);

        ImageButton tokoKesehatanButton= findViewById(R.id.btn_menu2_1);
        tokoKesehatanButton.setOnClickListener(this);

        datacovidResultMeninggal = findViewById(R.id.txtdatameninggal);
        datacovidResultPositif = findViewById(R.id.txtdatapositif);
        datacovidResultSembuh = findViewById(R.id.txtdatasembuh);
        messageAPI= findViewById(R.id.txtmessageAPI);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.kawalcorona.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);

        Call<List<GetDataCovid>> call = jsonPlaceHolderAPI.getDatas();

        call.enqueue(new Callback<List<GetDataCovid>>() {
            @Override
            public void onResponse(Call<List<GetDataCovid>> call, Response<List<GetDataCovid>> response) {
                    if(!response.isSuccessful()){
                        messageAPI.setText("Code : " + response.code());
                        return;
                    }
                    List<GetDataCovid> getDataCovids = response.body();
                    for (GetDataCovid getDataCovid : getDataCovids){
                        String sembuh="",positif="",meninggal="";
                        positif += getDataCovid.getPositif();
                        meninggal += getDataCovid.getMeninggal();
                        sembuh += getDataCovid.getSembuh();

                        datacovidResultMeninggal.append(meninggal);
                        datacovidResultSembuh.append(sembuh);
                        datacovidResultPositif.append(positif);
                    }
            }

            @Override
            public void onFailure(Call<List<GetDataCovid>> call, Throwable t) {
                messageAPI.setText(t.getMessage());
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beranda:
                        return true;
                    case R.id.transaksi:
                        startActivity(new Intent(getApplicationContext(), RiwayatTransaksiActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
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
                return false;
            }
        });
    }

    private void moveToLogin() {
        Intent toLogin = new Intent(MainActivity.this, Onboarding.class);
        toLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(toLogin);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu1_3:
                Intent toTreatmentIntent= new Intent(MainActivity.this, TreatmentActivity.class);
                startActivity(toTreatmentIntent);
                break;
            case R.id.btn_menu2_1:
                Intent toTokoKesehatanIntent= new Intent(MainActivity.this, TokoKesehatanActivity.class);
                startActivity(toTokoKesehatanIntent);
                break;
            case R.id.btn_menu1_2:
                Intent toBeritaIntent= new Intent(MainActivity.this, BeritaCovidActivity.class);
                startActivity(toBeritaIntent);
                break;
            case R.id.btn_menu2_2:
                Intent toJadwalIntent= new Intent(MainActivity.this, JadwalObatActivity.class);
                startActivity(toJadwalIntent);
                break;
            case R.id.btn_menu1_1:
                Intent toZona= new Intent(MainActivity.this, ZonaCovid.class);
                startActivity(toZona);
                break;

        }
    }
}