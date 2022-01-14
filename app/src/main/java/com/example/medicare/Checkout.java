package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {

    ImageButton button;
    TextView alamat ;
    Button buttonToPembayaran;
    String current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        button = findViewById(R.id.imageButton16);
        buttonToPembayaran = findViewById(R.id.buttonToPembayaran);
        alamat = findViewById(R.id.textView27);
        current = getIntent().getStringExtra("CURRENT_LOCATION");
        alamat.setText(current);

        buttonToPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPembayaran = new Intent(Checkout.this, PembayaranActivity.class);

                toPembayaran.putExtra("CURRENT_LOCATION2", current);
                startActivity(toPembayaran);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHalamanPeta= new Intent(Checkout.this, MapsActivity.class);
                startActivity(toHalamanPeta);
            }
        });
    }
}