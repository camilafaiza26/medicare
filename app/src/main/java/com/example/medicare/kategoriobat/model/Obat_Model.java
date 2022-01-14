package com.example.medicare.kategoriobat.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.medicare.treatment_covid.Treatment_Covid;

public class Obat_Model   implements Parcelable {
    public Obat_Model(int id, String image, String nama_obat, String kategori, int harga_obat, String satuan_obat, String indikasi_umum, String perhatian, String frekuensi, String komposisi) {
        this.id = id;
        this.image = image;
        this.nama_obat = nama_obat;
        this.kategori = kategori;
        this.harga_obat = harga_obat;
        this.satuan_obat = satuan_obat;
        this.indikasi_umum = indikasi_umum;
        this.perhatian = perhatian;
        this.frekuensi = frekuensi;
        this.komposisi = komposisi;
    }

    private String image;
    private int id;
    private String nama_obat;
    private String kategori;
    private int harga_obat;
    private String satuan_obat;
    private String indikasi_umum;
    private String perhatian;
    private String frekuensi;
    private String komposisi;

    protected Obat_Model(Parcel in) {
        image = in.readString();
        nama_obat = in.readString();
        kategori = in.readString();
        harga_obat = in.readInt();
        satuan_obat = in.readString();
        indikasi_umum = in.readString();
        perhatian = in.readString();
        frekuensi = in.readString();
        komposisi = in.readString();

    }

    public static final Parcelable.Creator<Obat_Model> CREATOR = new Parcelable.Creator<Obat_Model>() {
        @Override
        public Obat_Model createFromParcel(Parcel in) {
            return new Obat_Model (in);
        }

        @Override
        public Obat_Model[] newArray(int size) {
            return new Obat_Model [size];
        }
    };

    public Obat_Model (){
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getId() {
        return id;
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

    public String getIndikasi_umum() {
        return indikasi_umum;
    }

    public void setIndikasi_umum(String indikasi_umum) {
        this.indikasi_umum = indikasi_umum;
    }

    public String getPerhatian() {
        return perhatian;
    }

    public void setPerhatian(String perhatian) {
        this.perhatian = perhatian;
    }

    public String getFrekuensi() {
        return frekuensi;
    }

    public void setFrekuensi(String frekuensi) {
        this.frekuensi = frekuensi;
    }

    public String getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( image);
        parcel.writeString(nama_obat);
        parcel.writeString(kategori);
        parcel.writeInt(harga_obat);
        parcel.writeString( satuan_obat);
        parcel.writeString(indikasi_umum);
        parcel.writeString( perhatian);
        parcel.writeString(frekuensi);
        parcel.writeString(komposisi);
    }



}
