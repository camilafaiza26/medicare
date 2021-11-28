package com.example.medicare.beritacovid;
import com.example.medicare.R;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi;
import com.example.medicare.treatment_covid.Treatment_Covid;

import java.util.ArrayList;
public class Berita_Covid_Data {
    //Fake Data
    private static String[] judulBerita = {
            "58 Kasus Kematian Akibat Covid",
            "DKI Jakarta sumbang kasus terbanyak",
            "PPKM Berakhir berikut grafik terbaru covid",
            "Apakah ibu menyusui boleh vaksin?",
    };

    private static String[] waktu = {
            "1 hour ago",
            "two days ago",
            "1 hours ago",
            "2 hours ago",

    };
    private static String[] sumber = {
            "CNN Indonesia",
            "CNN Indonesia",
            "CNN Indonesia",
            "CNN Indonesia",
    };
    private static int[] fotoBerita= {
            R.drawable.berita1,
            R.drawable.berita2,
            R.drawable.berita3,
            R.drawable.berita4
    };

    public static ArrayList<Berita_Covid> getListData() {
        ArrayList<Berita_Covid> list = new ArrayList<>();
        for (int position = 0; position < judulBerita.length; position++) {
            Berita_Covid beritacovid= new Berita_Covid();
            beritacovid.setJudulBerita(judulBerita[position]);
            beritacovid.setWaktu(waktu[position]);
            beritacovid.setSumber(sumber[position]);
            beritacovid.setFotoBerita(fotoBerita[position]);

            list.add(beritacovid);
        }
        return list;
    }
}
