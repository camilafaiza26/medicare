package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TokoKesehatanActivity extends AppCompatActivity implements  View.OnClickListener {

    private ImageButton kategoriButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko_kesehatan);

        ImageButton treatmentButton= findViewById(R.id.btn_cat1_1);
        treatmentButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cat1_1:
                Intent toHalamanKategori= new Intent(TokoKesehatanActivity.this, KategoriObatActivity.class);
                startActivity( toHalamanKategori);
                break;

        }
    }
}