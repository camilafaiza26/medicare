package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi_Adapter;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi_Data;
import com.example.medicare.tampil_jadwal_obat.Jadwal_Obat;
import com.example.medicare.tampil_jadwal_obat.Jadwal_Obat_Adapter;
import com.example.medicare.tampil_jadwal_obat.Jadwal_Obat_Data;
import com.example.medicare.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class JadwalObatActivity extends AppCompatActivity implements  View.OnClickListener {
    BottomNavigationView bottomNavigationView;
    ImageButton backbutton3;
    Button tambahjadwal;

    private RecyclerView rvJadwalObat;
    private ArrayList<Jadwal_Obat> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_obat);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.jadwal);

        backbutton3 = findViewById(R.id.backButton3);
        backbutton3.setOnClickListener(this);
        tambahjadwal = findViewById(R.id.tambahjadwal);
        tambahjadwal.setOnClickListener(this);

        rvJadwalObat = findViewById(R.id.rv_jadwal_obat);
        rvJadwalObat.setHasFixedSize(true);

        list.addAll(Jadwal_Obat_Data.getListData());
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
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.jadwal:
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton3:
                Intent jadwalIntent = new Intent(JadwalObatActivity.this, MainActivity.class);
                startActivity(jadwalIntent);
                break;
            case R.id.tambahjadwal:
                Intent tambahjadwalIntent = new Intent(JadwalObatActivity.this, TambahJadwalObat.class);
                startActivity(tambahjadwalIntent);
                break;

        }
    }
    private void showRecyclerList() {
        rvJadwalObat.setLayoutManager(new LinearLayoutManager(this));
        Jadwal_Obat_Adapter jadwal_obat_adapter = new Jadwal_Obat_Adapter(list);
        rvJadwalObat.setAdapter(jadwal_obat_adapter);

    }
}