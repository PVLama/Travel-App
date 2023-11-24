package com.example.btlandroid_travelapp.model;

import java.io.Serializable;

public class Foods implements Serializable {
    int ID;
    String Tenmonan;
    String Hinhanh;
    String Mota;
    int idMonan;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenmonan() {
        return Tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        Tenmonan = tenmonan;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getIdMonan() {
        return idMonan;
    }

    public void setIdMonan(int idMonan) {
        this.idMonan = idMonan;
    }
}

