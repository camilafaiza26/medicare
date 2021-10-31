package com.example.medicare.riwayat_transaksi;

import com.example.medicare.R;

import java.util.ArrayList;

public class Riwayat_Transaksi_Data {

    //Fake Data
    private static String[] namaObat = {
                "Panadol",
                "Combi Obat Batuk",
                "BlackMores Vitamin C",
                "Panadol",
                "Combi Obat Batuk",
                "BlackMores Vitamin C",
                "Panadol",
                "Combi Obat Batuk",
                "BlackMores Vitamin C",
        };
    private static int[] jumlahObat ={
            1,
            12,
            1,
            1,
            12,
            1,
            1,
            12,
            1,

    };
    private static int[] totalHargaObat = {
            190000,
            120000,
            520000,
            190000,
            120000,
            520000,
            190000,
            120000,
            520000,
    };
    private static String[] statusPembelian = {
            "Selesai",
            "Selesai",
            "Selesai",
            "Selesai",
            "Selesai",
            "Selesai",
            "Selesai",
            "Selesai",
            "Selesai",
    };private static String[] waktuTransaksi = {
            "17 Sep 2021 20:00",
            "18 Sep 2021 20:00",
            "19 Sep 2021 10:00",
            "20 Sep 2021 07:00",
            "21 Sep 2021 08:00",
            "23 Sep 2021 10:00",
            "15 Okt 2021 12:00",
            "18 Okt 2021 10:00",
            "15 Des 2021 10:00",
    };
    private static int[] fotoObat= {
            R.drawable.panadol,
            R.drawable.combi,
            R.drawable.blackmores,
            R.drawable.panadol,
            R.drawable.combi,
            R.drawable.blackmores,
            R.drawable.panadol,
            R.drawable.combi,
            R.drawable.blackmores
    };
    public static ArrayList<Riwayat_Transaksi> getListData() {
        ArrayList<Riwayat_Transaksi> list = new ArrayList<>();
        for (int position = 0; position < namaObat.length; position++) {
            Riwayat_Transaksi riwayat_transaksi= new Riwayat_Transaksi();
            riwayat_transaksi.setNamaObat(namaObat[position]);
            riwayat_transaksi.setJumlahObat(jumlahObat[position]);
            riwayat_transaksi.setTotalHargaObat(totalHargaObat[position]);
            riwayat_transaksi.setStatusPembelian(statusPembelian[position]);
            riwayat_transaksi.setWaktuTransaksi(waktuTransaksi[position]);
            riwayat_transaksi.setFotoObat(fotoObat[position]);

            list.add(riwayat_transaksi);
        }
             return list;
   }


}
