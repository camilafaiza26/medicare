package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.medicare.kategoriobat.Kategori_Obat;
import com.example.medicare.kategoriobat.Kategori_Obat_Adapter;
import com.example.medicare.kategoriobat.Kategori_Obat_Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class KategoriObatActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private RecyclerView rvKategoriObat;
    private ArrayList<Kategori_Obat> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_obat);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.telepon);

        rvKategoriObat = findViewById(R.id.rv_kategori_obat);
        rvKategoriObat.setHasFixedSize(true);

        list.addAll(Kategori_Obat_Data.getListData());
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
        rvKategoriObat.setLayoutManager(new GridLayoutManager(this, 2));
        Kategori_Obat_Adapter kategori_obat_adapter = new Kategori_Obat_Adapter(list);
        rvKategoriObat.setAdapter(kategori_obat_adapter );

    }
}
