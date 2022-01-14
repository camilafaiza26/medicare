package com.example.medicare.zona_covid;

import java.util.ArrayList;
import java.util.Collection;

public class Zona_Covid_Data {
    //Fake Data
    private static String[] kodeProvinsi = {
            "A01",
            "A02",
            "A03",
    };
    private static String[] provinsi = {
            "Sumbar",
            "Jabar",
            "DKI Jakarta",
    };
    private static int[] positif = {
            12,
            44,
            55,
    };
    private static int[] negatif = {
            12,
            10,
            9,
    };
    private static int[] meninggal = {
            12,
            10,
            9,
    };

    public static Collection<? extends Zona_Covid> getListData() {
        ArrayList<Zona_Covid> list = new ArrayList<>();
        for (int position = 0; position < kodeProvinsi.length; position++) {
            Zona_Covid zona_covid= new Zona_Covid();
            zona_covid.setKodeProvinsi(kodeProvinsi[position]);
            zona_covid.setProvinsi(provinsi[position]);
            zona_covid.setPositif(positif[position]);
            zona_covid.setNegatif(negatif[position]);
            zona_covid.setMeninggal(meninggal[position]);

            list.add(zona_covid);
        }
        return list;
    }

}