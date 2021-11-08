package com.example.medicare.tampil_jadwal_obat;

public class Jadwal_Obat {
    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getStatusJadwal() {
        return statusJadwal;
    }

    public void setStatusJadwal(String statusJadwal) {
        this.statusJadwal = statusJadwal;
    }

    public String getJadwalObat() {
        return jadwalObat;
    }

    public void setJadwalObat(String jadwalObat) {
        this.jadwalObat = jadwalObat;
    }

    private String namaObat;
    private String statusJadwal;
    private String jadwalObat;  //Bakal diganti time
}
