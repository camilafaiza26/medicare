package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


import com.example.medicare.ui.login.LoginActivity;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Onboarding extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        SliderView sliderView = findViewById(R.id.imageSlider);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.one);
        images.add(R.drawable.two);
        images.add(R.drawable.three);
        images.add(R.drawable.four);
        images.add(R.drawable.five);

        AdapterOnboarding adapterOnboarding = new AdapterOnboarding(images);

        sliderView.setSliderAdapter(adapterOnboarding);

        Button toLogin = findViewById(R.id.toLogin);
        toLogin.setOnClickListener(this);
        Button toRegis = findViewById(R.id.toRegister);
        toRegis.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toLogin:
                Intent loginIntent = new Intent(Onboarding.this, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.toRegister:
                Intent registerIntent = new Intent(Onboarding.this, RegisterActivity.class);
                startActivity(registerIntent);
                break;
        }
    }
}