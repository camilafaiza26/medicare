package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TambahJadwalObat extends AppCompatActivity  implements  View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_jadwal_obat);

        ImageButton toJadwalObat = findViewById(R.id.backButton4);
        toJadwalObat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backButton4:
                Intent toJadwalIntent = new Intent(TambahJadwalObat.this, JadwalObatActivity.class);
                startActivity(toJadwalIntent);
                break;

        }
    }
}