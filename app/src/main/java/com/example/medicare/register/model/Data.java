package com.example.medicare.register.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;
    @SerializedName("tanggallahir")
    @Expose
    private Object tanggallahir;
    @SerializedName("tinggi")
    @Expose
    private Object tinggi;
    @SerializedName("berat")
    @Expose
    private Object berat;
    @SerializedName("jeniskelamin")
    @Expose
    private Object jeniskelamin;
    @SerializedName("token")
    @Expose
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Object getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(Object tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public Object getTinggi() {
        return tinggi;
    }

    public void setTinggi(Object tinggi) {
        this.tinggi = tinggi;
    }

    public Object getBerat() {
        return berat;
    }

    public void setBerat(Object berat) {
        this.berat = berat;
    }

    public Object getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(Object jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}