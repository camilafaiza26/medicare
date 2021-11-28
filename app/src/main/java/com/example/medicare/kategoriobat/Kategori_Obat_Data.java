package com.example.medicare.kategoriobat;

import com.example.medicare.R;
import com.example.medicare.tenagamedis.Tenaga_Medis;

import java.util.ArrayList;

public class Kategori_Obat_Data {
    private static String[] namaobat = {
            "Panadol   ",
            "Kombi  ",
            "viks ",
    };
    private static String[] ket = {
            "Per Strip",
            "Botol",
            "botol",
    };
    private static String[] harga = {
            "Rp8.000,00",
            "Rp10.000,00",
            "Rp12.000,00",
    };
    private static int[] fotoobat= {
            R.drawable.panadol,
            R.drawable.combi,
            R.drawable.viks,

    };
    public static ArrayList<Kategori_Obat> getListData() {
        ArrayList<Kategori_Obat> list = new ArrayList<>();
        for (int position = 0; position < namaobat.length; position++) {
            Kategori_Obat kategori_obat= new Kategori_Obat();
            kategori_obat.setNamaobat(namaobat[position]);
            kategori_obat.setKet(ket[position]);
            kategori_obat.setHarga(harga[position]);
            kategori_obat.setFotoobat(fotoobat[position]);
            list.add(kategori_obat);
        }
        return list;
    }
}
