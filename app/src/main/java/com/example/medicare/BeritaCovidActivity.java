package com.example.medicare;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.medicare.beritacovid.Berita_Covid;
import com.example.medicare.beritacovid.Berita_Covid_Adapter;
import com.example.medicare.beritacovid.Berita_Covid_Data;
//import com.example.medicare.kategoriobat.Kategori_Obat_Adapter;
import com.example.medicare.treatment_covid.Treatment_Covid;
import com.example.medicare.treatment_covid.Treatment_Covid_Adapter;
import com.example.medicare.treatment_covid.Treatment_Covid_Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
public class BeritaCovidActivity extends AppCompatActivity {
    private RecyclerView rvBeritaCovid;
    private ArrayList<Berita_Covid> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_covid);


        rvBeritaCovid = findViewById(R.id.rv_berita_covid);
        rvBeritaCovid.setHasFixedSize(true);

        list.addAll(Berita_Covid_Data.getListData());
        showRecyclerList();

    }
    private void showRecyclerList() {
        rvBeritaCovid.setLayoutManager(new GridLayoutManager(this, 2));
        Berita_Covid_Adapter berita_covid_adapter = new Berita_Covid_Adapter(list);
        rvBeritaCovid.setAdapter(berita_covid_adapter);

    }
}
