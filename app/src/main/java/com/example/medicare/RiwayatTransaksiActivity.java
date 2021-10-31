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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class RiwayatTransaksiActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvRiwayatTransaksi;
    private ArrayList<Riwayat_Transaksi> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_transaksi);



        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.transaksi);

        rvRiwayatTransaksi = findViewById(R.id.rv_riwayat_transaksi);
        rvRiwayatTransaksi.setHasFixedSize(true);

        list.addAll(Riwayat_Transaksi_Data.getListData());
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
        rvRiwayatTransaksi.setLayoutManager(new LinearLayoutManager(this));
        Riwayat_Transaksi_Adapter riwayat_transaksi_adapter = new Riwayat_Transaksi_Adapter(list);
        rvRiwayatTransaksi.setAdapter(riwayat_transaksi_adapter);

    }
}