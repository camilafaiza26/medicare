package com.example.medicare.beritacovid;
import android.os.Parcel;
import android.os.Parcelable;


public class Berita_Covid implements Parcelable {
    private String judulBerita;
    private String waktu;
    private String sumber;
    private int fotoBerita;
    private String description;
    private String cuplikan;

    protected Berita_Covid(Parcel in) {
        judulBerita = in.readString();
        waktu = in.readString();
        sumber = in.readString();
        cuplikan = in.readString();
        description = in.readString();
        fotoBerita = in.readInt();
    }
    public static final Parcelable.Creator<Berita_Covid> CREATOR = new Parcelable.Creator<Berita_Covid>() {
        @Override
        public Berita_Covid createFromParcel(Parcel in) {
            return new Berita_Covid (in);
        }

        @Override
        public Berita_Covid[] newArray(int size) {
            return new Berita_Covid [size];
        }
    };
    public Berita_Covid() {

    }

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

    public String getCuplikan() {
        return cuplikan;
    }

    public void setCuplikan(String cuplikan) {
        this.cuplikan = cuplikan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFotoBerita() {
        return fotoBerita;
    }

    public void setFotoBerita(int fotoBerita) {
        this.fotoBerita = fotoBerita;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( judulBerita);
        parcel.writeString(waktu);
        parcel.writeString(sumber);
        parcel.writeString(cuplikan);
        parcel.writeString( description);
        parcel.writeInt(fotoBerita);
    }


}