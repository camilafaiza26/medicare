package com.example.medicare.tenagamedis;

import com.example.medicare.R;
import com.example.medicare.tampil_jadwal_obat.Jadwal_Obat;

import java.util.ArrayList;

public class Tenaga_Medis_Data {

    private static String[] namaRS = {
            "RSUP Dr. M. Djamil   ",
            "Semen Padang Hospital",
            "RS Islam Siti Rahmah ",
    };
    private static String[] alamatRS = {
            "Jl. Perintis Kemerdekaan, Sawahan Tim...",
            "Jl. By Pass No.KM. 7, Pisang...",
            "Jl. By Pass No.KM.15, Aie Pacah...",
    };
    private static String[] noTelpRS = {
            "(0751) 32371",
            "081276910995",
            "(0751) 463059",
    };
    private static int[] fotoRumahSakit= {
            R.drawable.rs_mdjamil,
            R.drawable.rs_sph,
            R.drawable.rs_baiturahmah,
    };
    public static ArrayList<Tenaga_Medis> getListData() {
        ArrayList<Tenaga_Medis> list = new ArrayList<>();
        for (int position = 0; position < namaRS.length; position++) {
            Tenaga_Medis tenaga_medis= new Tenaga_Medis();
            tenaga_medis.setNamaRS(namaRS[position]);
            tenaga_medis.setAlamatRS(alamatRS[position]);
            tenaga_medis.setNoTelpRS(noTelpRS[position]);
            tenaga_medis.setFotoRumahSakit(fotoRumahSakit[position]);
            list.add(tenaga_medis);
        }
        return list;
    }
}
