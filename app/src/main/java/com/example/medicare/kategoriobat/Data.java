package com.example.medicare.kategoriobat;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("nama_obat")
    @Expose
    private String namaObat;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("harga_obat")
    @Expose
    private Integer hargaObat;
    @SerializedName("satuan_obat")
    @Expose
    private String satuanObat;
    @SerializedName("indikasi_umum")
    @Expose
    private String indikasiUmum;
    @SerializedName("perhatian")
    @Expose
    private String perhatian;
    @SerializedName("frekuensi")
    @Expose
    private String frekuensi;
    @SerializedName("komposisi")
    @Expose
    private String komposisi;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Integer getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(Integer hargaObat) {
        this.hargaObat = hargaObat;
    }

    public String getSatuanObat() {
        return satuanObat;
    }

    public void setSatuanObat(String satuanObat) {
        this.satuanObat = satuanObat;
    }

    public String getIndikasiUmum() {
        return indikasiUmum;
    }

    public void setIndikasiUmum(String indikasiUmum) {
        this.indikasiUmum = indikasiUmum;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
