package com.example.medicare.tampil_jadwal_obat;

import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi;

import java.util.ArrayList;

public class Jadwal_Obat_Data {

    //FAKE DATA
    private static String[] namaObat = {
            "Panadol",
            "Combi Obat Batuk",
            "BlackMores Vitamin C",
            "Alfita",
            "BlackMores Minyak ikan",
            "Polysilane",
    };
    private static String[] jadwalObat = {
            "10 : 00",
            "12 : 00",
            "13 : 30",
            "08 : 30",
            "19 : 18",
            "15 : 55",
    };
    private static String[] statusObat = {
            "Selesai",
            "Terlampaui",
            "Belum",
            "Belum",
            "Belum",
            "Terlampaui",
    };

    public static ArrayList<Jadwal_Obat> getListData() {
        ArrayList<Jadwal_Obat> list = new ArrayList<>();
        for (int position = 0; position < namaObat.length; position++) {
            Jadwal_Obat jadwal_obat= new Jadwal_Obat();
            jadwal_obat.setNamaObat(namaObat[position]);
            jadwal_obat.setStatusJadwal(statusObat[position]);
            jadwal_obat.setJadwalObat(jadwalObat[position]);

            list.add(jadwal_obat);
        }
        return list;
    }


}
