package com.example.medicare.beritacovid;

public class Berita_Covid {
    public String getJudulBerita() {
        return judulBerita;
    }

    public void setJudulBerita(String judulBerita) {
        this.judulBerita = judulBerita;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public int getFotoBerita() {
        return fotoBerita;
    }

    public void setFotoBerita(int fotoBerita) {
        this.fotoBerita = fotoBerita;
    }

    private String judulBerita;
    private String waktu;
    private String sumber;
    private int fotoBerita;
}
