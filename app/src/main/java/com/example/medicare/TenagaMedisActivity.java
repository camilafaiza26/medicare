package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi_Adapter;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi_Data;
import com.example.medicare.tenagamedis.Tenaga_Medis;
import com.example.medicare.tenagamedis.Tenaga_Medis_Adapter;
import com.example.medicare.tenagamedis.Tenaga_Medis_Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class TenagaMedisActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private RecyclerView rvTenagaMedis;
    private ArrayList<Tenaga_Medis> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenaga_medis);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.telepon);

        rvTenagaMedis = findViewById(R.id.rv_tenaga_medis);
        rvTenagaMedis.setHasFixedSize(true);

        list.addAll(Tenaga_Medis_Data.getListData());
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
                        startActivity(new Intent(getApplicationContext(), RiwayatTransaksiActivity.class));
                        overridePendingTransition(0,0);
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.jadwal:
                        startActivity(new Intent(getApplicationContext(), JadwalObatActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.telepon:
                        return true;

                }
                return false;
            }
        });

    }
    private void showRecyclerList() {
        rvTenagaMedis.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        Tenaga_Medis_Adapter tenaga_medis_adapter = new Tenaga_Medis_Adapter(list);
        rvTenagaMedis.setAdapter(tenaga_medis_adapter );

    }
}