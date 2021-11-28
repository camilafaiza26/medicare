package com.example.medicare.kategoriobat;

public class Kategori_Obat {
    public String getNamaobat() {
        return namaobat;
    }

    public void setNamaobat(String namaobat) {
        this.namaobat = namaobat;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getFotoobat() {
        return fotoobat;
    }

    public void setFotoobat(int fotoobat) {
        this.fotoobat = fotoobat;
    }

    private String namaobat;
    private String ket;
    private String harga;
    private int fotoobat;
}
