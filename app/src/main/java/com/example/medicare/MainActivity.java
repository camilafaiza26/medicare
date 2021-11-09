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
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        ImageButton treatmentButton= findViewById(R.id.btn_menu1_3);
        treatmentButton.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu1_3:
                Intent toTreatmentIntent= new Intent(MainActivity.this, TreatmentActivity.class);
                startActivity(toTreatmentIntent);
                break;

        }
    }
}