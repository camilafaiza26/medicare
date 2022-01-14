package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi_Adapter;
import com.example.medicare.zona_covid.Zona_Covid;
import com.example.medicare.zona_covid.Zona_Covid_Adapter;
import com.example.medicare.zona_covid.Zona_Covid_Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class ZonaCovid extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvZonaCovid;
    private ArrayList<Zona_Covid> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona_covid);



        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.transaksi);

        rvZonaCovid = findViewById(R.id.rv_zona_covid);
        rvZonaCovid.setHasFixedSize(true);

        list.addAll(Zona_Covid_Data.getListData());
        showRecyclerList();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beranda:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.transaksi:
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

    private void showRecyclerList() {
        rvZonaCovid.setLayoutManager(new LinearLayoutManager(this));
        Zona_Covid_Adapter zona_covid_adapter = new Zona_Covid_Adapter(list);
        rvZonaCovid.setAdapter(zona_covid_adapter);

    }
}