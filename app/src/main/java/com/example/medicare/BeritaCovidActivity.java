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

import com.example.medicare.beritacovid.Berita_Covid;
import com.example.medicare.beritacovid.Berita_Covid_Adapter;
import com.example.medicare.beritacovid.Berita_Covid_Data;
//import com.example.medicare.kategoriobat.Kategori_Obat_Adapter;
import com.example.medicare.beritacovid.Detail_Berita_Activity;
import com.example.medicare.treatment_covid.Detail_Treatment_Activity;
import com.example.medicare.treatment_covid.Treatment_Covid;
import com.example.medicare.treatment_covid.Treatment_Covid_Adapter;
import com.example.medicare.treatment_covid.Treatment_Covid_Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class BeritaCovidActivity extends AppCompatActivity implements Berita_Covid_Adapter.OnClickListener, View.OnClickListener {
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
        Berita_Covid_Adapter berita_covid_adapter = new Berita_Covid_Adapter(list,this);
        rvBeritaCovid.setAdapter(berita_covid_adapter);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.treatment_backButton:
                Intent toHomeIntent = new Intent(BeritaCovidActivity.this, MainActivity.class);
                startActivity(toHomeIntent);
                break;

        }
    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(BeritaCovidActivity.this, Detail_Berita_Activity.class);
        intent.putExtra("pilih", list.get(position));
        startActivity(intent);
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

    }
}