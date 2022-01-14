package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.medicare.API.ApiClient;
import com.example.medicare.kategoriobat.Data;
import com.example.medicare.kategoriobat.Kategori_Obat;
//import com.example.medicare.kategoriobat.Kategori_Obat_Adapter;
//import com.example.medicare.kategoriobat.Kategori_Obat_Data;
import com.example.medicare.kategoriobat.Kategori_Obat_Adapter;
import com.example.medicare.kategoriobat.ObatInterface;
import com.example.medicare.kategoriobat.model.Obat_Model;
import com.example.medicare.treatment_covid.Detail_Treatment_Activity;
import com.example.medicare.treatment_covid.Treatment_Covid_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KategoriObatActivity extends AppCompatActivity implements Kategori_Obat_Adapter.OnClickListener, View.OnClickListener {
    BottomNavigationView bottomNavigationView;

    private RecyclerView rvKategoriObat;
    private ArrayList<Obat_Model> list ;


private static ObatInterface obatInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_obat);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.telepon);

        rvKategoriObat = findViewById(R.id.rv_kategori_obat);
        rvKategoriObat.setHasFixedSize(true);

        ImageButton backButton = findViewById(R.id.backToTK);
        backButton.setOnClickListener(this);



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
        showgrid();

    }

    private void showgrid() {
        obatInterface = ApiClient.getClient().create(ObatInterface.class);
        Call<Kategori_Obat> call = obatInterface.getObat();
        call.enqueue(new Callback<Kategori_Obat>() {
            @Override
            public void onResponse(Call<Kategori_Obat> call, Response<Kategori_Obat> response) {
                Kategori_Obat kategori_obat = response.body();
                list = new ArrayList<>();
                if(kategori_obat != null){
                    List<Data> items = kategori_obat.getData();
                    for (Data item : items){
                        Obat_Model obat_model = new Obat_Model(
                                item.getId(),
                                item.getImage(),
                                item.getNamaObat(),
                                item.getKategori(),
                                item.getHargaObat(),
                                item.getSatuanObat(),
                                item.getIndikasiUmum(),
                                item.getPerhatian(),
                                item.getFrekuensi(),
                                item.getKomposisi()
                        );
                       list.add(obat_model);

                    }
                    showRecyclerList();
                }
            }

            @Override
            public void onFailure(Call<Kategori_Obat> call, Throwable t) {

            }
        });

    }
    private void showRecyclerList() {
        rvKategoriObat.setLayoutManager(new GridLayoutManager(this, 2));
        Kategori_Obat_Adapter kategori_obat_adapter = new Kategori_Obat_Adapter(list,this);
        rvKategoriObat.setAdapter(kategori_obat_adapter );

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backToTK:
                Intent toHomeIntent = new Intent(KategoriObatActivity.this, TokoKesehatanActivity.class);
                startActivity(toHomeIntent);
                break;

        }
    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(KategoriObatActivity.this, DetailObatActivity.class);
        intent.putExtra("pilih", list.get(position));
        startActivity(intent);

    }
}
