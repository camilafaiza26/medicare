package com.example.medicare.treatment_covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicare.MainActivity;
import com.example.medicare.R;
import com.example.medicare.TreatmentActivity;

public class Detail_Treatment_Activity extends AppCompatActivity  implements  View.OnClickListener{

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_treatment);

        ImageButton backButton = findViewById(R.id.backButtonTR);
        backButton.setOnClickListener(this);

        Intent intent = getIntent();
        Treatment_Covid treatment_covid = intent.getParcelableExtra("pilih");

        assert treatment_covid  != null;
        int fotoTreatment = treatment_covid .getFotoTreatment();
        String judulTreatment = treatment_covid .getJudulTreatment();
        String update = treatment_covid .getUpdate();
//        String cuplikan =treatment_covid .getCuplikan();
        String penerbit = treatment_covid .getPenerbit();
        String description = treatment_covid .getDescription();

        ImageView imageView = findViewById(R.id.img_foto_treatment);
        imageView.setImageResource(fotoTreatment);
        TextView textView = findViewById(R.id.txt_judul_treatment);
        textView.setText(judulTreatment);
        TextView textView1 = findViewById(R.id.txt_update);
        textView1.setText(update);
        TextView textView2 = findViewById(R.id.txt_data_penerbit_trt);
        textView2.setText(penerbit);
        TextView textView3 = findViewById(R.id.txt_data_description_trt);
        textView3.setText(description);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backButtonTR:
                Intent toHomeIntent = new Intent(Detail_Treatment_Activity.this, TreatmentActivity.class);
                startActivity(toHomeIntent);
                break;

        }
    }
}