package com.example.medicare.treatment_covid;

import com.example.medicare.R;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi;

import java.util.ArrayList;

public class Treatment_Covid_Data {
    //Fake Data
    private static String[] judulTreatment = {
            "Ini obat terapi covid gejala ringan sampai berat versi ..",
            "Pertama kalinya, ini obat untuk pengobatan covid....",
            "Pengobatan covid-19",
    };

    private static String[] update = {
            "17 hours ago",
            "two days ago",
            "12 hours ago",

    };
    private static String[] cuplikan = {
            "Jokowi menyampaikan terapi obat yang bisa digunakan oleh pasien Covid-19 untuk tanpa gejala hingga ringan.",
            "Untuk pertama kalinya ditemukan obat yang bisa digunakan untuk pengobatan covid",
            "Dokter dan ilmuwan hingga kini masih berusaha memahami gambaran lengkap virus corona.",
    };
    private static int[] fotoTreatment= {
            R.drawable.tr1,
            R.drawable.tr2,
            R.drawable.tr3
    };

    public static ArrayList<Treatment_Covid> getListData() {
        ArrayList<Treatment_Covid> list = new ArrayList<>();
        for (int position = 0; position < judulTreatment.length; position++) {
            Treatment_Covid treatmentcovid= new Treatment_Covid();
            treatmentcovid.setJudulTreatment(judulTreatment[position]);
            treatmentcovid.setUpdate(update[position]);
            treatmentcovid.setCuplikan(cuplikan[position]);
            treatmentcovid.setFotoTreatment(fotoTreatment[position]);

            list.add(treatmentcovid);
        }
        return list;
    }
}
