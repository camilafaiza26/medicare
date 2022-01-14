package com.example.medicare.zona_covid;


public class Zona_Covid {
    public String getKodeProvinsi() {
        return kodeProvinsi;
    }

    public void setKodeProvinsi(String kodeProvinsi) {
        this.kodeProvinsi = kodeProvinsi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public int getPositif() {
        return positif;
    }

    public void setPositif(int positif) {
        this.positif = positif;
    }

    public int getNegatif() {
        return negatif;
    }

    public void setNegatif(int negatif) {
        this.negatif = negatif;
    }

    public int getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(int meninggal) {
        this.meninggal = meninggal;
    }

    private String kodeProvinsi;
    private String provinsi;
    private int positif;
    private int negatif;
    private int meninggal;
}