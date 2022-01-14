package com.example.medicare.cart;

public class Cart {


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getHarga_obat() {
        return harga_obat;
    }

    public void setHarga_obat(int harga_obat) {
        this.harga_obat = harga_obat;
    }

    public String getSatuan_obat() {
        return satuan_obat;
    }

    public void setSatuan_obat(String satuan_obat) {
        this.satuan_obat = satuan_obat;
    }

    public int getJumlah_obat() {
        return jumlah_obat;
    }

    public void setJumlah_obat(int jumlah_obat) {
        this.jumlah_obat = jumlah_obat;
    }

    private String image;
    private int id;
    private String nama_obat;
    private String kategori;
    private int harga_obat;
    private String satuan_obat;
    private  int jumlah_obat;



    public Cart(String image, String nama_obat, String kategori, int harga_obat, String satuan_obat, int jumlah_obat) {
        this.image = image;
        this.nama_obat = nama_obat;
        this.kategori = kategori;
        this.harga_obat = harga_obat;
        this.satuan_obat = satuan_obat;
        this.jumlah_obat = jumlah_obat;
    }

}
