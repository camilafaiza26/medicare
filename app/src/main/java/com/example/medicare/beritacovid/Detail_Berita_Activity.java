package com.example.medicare.beritacovid;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medicare.BeritaCovidActivity;
import com.example.medicare.MainActivity;
import com.example.medicare.R;
import com.example.medicare.beritacovid.Detail_Berita_Activity;
import com.example.medicare.treatment_covid.Treatment_Covid;

public class Detail_Berita_Activity extends AppCompatActivity  implements  View.OnClickListener {
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        ImageButton backButton = findViewById(R.id.backButtonBR);
        backButton.setOnClickListener(this);

        Intent intent = getIntent();
        Berita_Covid berita_covid = intent.getParcelableExtra("pilih");
        assert berita_covid  != null;
        int fotoBerita = berita_covid .getFotoBerita();
        String judulBerita = berita_covid .getJudulBerita();
        String waktu = berita_covid .getWaktu();
//        String cuplikan =treatment_covid .getCuplikan();
        String sumber = berita_covid .getSumber();
        String description = berita_covid .getDescription();

        ImageView imageView = findViewById(R.id.img_foto_berita);
        imageView.setImageResource(fotoBerita);
        TextView textView = findViewById(R.id.txt_judul_berita);
        textView.setText(judulBerita);
        TextView textView1 = findViewById(R.id.txt_waktu);
        textView1.setText(waktu);
        TextView textView2 = findViewById(R.id.txt_data_sumber);
        textView2.setText(sumber);
        TextView textView3 = findViewById(R.id.txt_data_description_berita);
        textView3.setText(description);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backButtonTR:
                Intent toHomeIntent = new Intent(Detail_Berita_Activity.this, BeritaCovidActivity.class);
                startActivity(toHomeIntent);
                break;

        }
    }

}