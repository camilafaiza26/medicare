package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.medicare.treatment_covid.Detail_Treatment_Activity;
import com.example.medicare.treatment_covid.Treatment_Covid;
import com.example.medicare.treatment_covid.Treatment_Covid_Adapter;
import com.example.medicare.treatment_covid.Treatment_Covid_Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class TreatmentActivity extends AppCompatActivity implements Treatment_Covid_Adapter.OnClickListener, View.OnClickListener {
    private RecyclerView rvTreatmentCovid;
    private ArrayList<Treatment_Covid> list = new ArrayList<>();
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);

        ImageButton backButton = findViewById(R.id.treatment_backButton);
        backButton.setOnClickListener(this);

        rvTreatmentCovid = findViewById(R.id.rv_treatment_covid);
        rvTreatmentCovid.setHasFixedSize(true);

        list.addAll(Treatment_Covid_Data.getListData());
        showRecyclerList();

    }
    private void showRecyclerList() {
        rvTreatmentCovid.setLayoutManager(new LinearLayoutManager(this));
        Treatment_Covid_Adapter treatment_covid_adapter = new Treatment_Covid_Adapter(list,this);
        rvTreatmentCovid.setAdapter(treatment_covid_adapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.treatment_backButton:
                Intent toHomeIntent = new Intent(TreatmentActivity.this, MainActivity.class);
                startActivity(toHomeIntent);
                break;

        }
    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(TreatmentActivity.this, Detail_Treatment_Activity.class);
        intent.putExtra("pilih", list.get(position));
        startActivity(intent);
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

    }
}
