package com.example.medicare.treatment_covid;

import android.os.Parcel;
import android.os.Parcelable;

public class Treatment_Covid  implements Parcelable {


    private String judulTreatment;
    private String update;
    private String cuplikan;


    private String penerbit;
    private String description;
    private int fotoTreatment;

    protected Treatment_Covid(Parcel in) {
        judulTreatment = in.readString();
        update = in.readString();
        cuplikan = in.readString();
        penerbit = in.readString();
        description = in.readString();
        fotoTreatment = in.readInt();
    }

    public static final Parcelable.Creator<Treatment_Covid> CREATOR = new Parcelable.Creator<Treatment_Covid>() {
        @Override
        public Treatment_Covid createFromParcel(Parcel in) {
            return new Treatment_Covid (in);
        }

        @Override
        public Treatment_Covid[] newArray(int size) {
            return new Treatment_Covid [size];
        }
    };

    public Treatment_Covid() {

    }

    public String getJudulTreatment() {
        return judulTreatment;
    }

    public void setJudulTreatment(String judulTreatment) {
        this.judulTreatment = judulTreatment;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getCuplikan() {
        return cuplikan;
    }

    public void setCuplikan(String cuplikan) {
        this.cuplikan = cuplikan;
    }

    public int getFotoTreatment() {
        return fotoTreatment;
    }

    public void setFotoTreatment(int fotoTreatment) {
        this.fotoTreatment = fotoTreatment;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( judulTreatment);
        parcel.writeString(update);
        parcel.writeString(cuplikan);
        parcel.writeString(penerbit);
        parcel.writeString( description);
        parcel.writeInt(fotoTreatment);
    }

}
