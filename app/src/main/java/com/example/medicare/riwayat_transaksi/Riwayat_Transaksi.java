package com.example.medicare.riwayat_transaksi;

import java.util.Date;

public class Riwayat_Transaksi {


    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getJumlahObat() {
        return jumlahObat;
    }

    public void setJumlahObat(int jumlahObat) {
        this.jumlahObat = jumlahObat;
    }

    public int getTotalHargaObat() {
        return totalHargaObat;
    }

    public void setTotalHargaObat(int totalHargaObat) {
        this.totalHargaObat = totalHargaObat;
    }

    public String getStatusPembelian() {
        return statusPembelian;
    }

    public void setStatusPembelian(String statusPembelian) {
        this.statusPembelian = statusPembelian;
    }

    public String getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(String waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }

    public int getFotoObat() {
        return fotoObat;
    }

    public void setFotoObat(int fotoObat) {
        this.fotoObat = fotoObat;
    }

    private String namaObat;
    private int jumlahObat;
    private int totalHargaObat;
    private String statusPembelian;
    private String waktuTransaksi;
    private int fotoObat;



}
