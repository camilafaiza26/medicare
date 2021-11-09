package com.example.medicare.zonacovid;
import  com.google.gson.annotations.SerializedName;

public class GetDataCovid {

    public String getName() {
        return name;
    }

    public String  getPositif() {
        return positif;
    }

    public String  getSembuh() {
        return sembuh;
    }

    public String  getMeninggal() {
        return meninggal;
    }

    private String positif;
    private String  sembuh;
    private String  meninggal;
    @SerializedName("body")
    private String name;


}
