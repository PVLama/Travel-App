package com.example.btlandroid_travelapp.model;

import java.io.Serializable;

public class TopPlaces implements Serializable {
    String ID;
    String Tendiadanh;
    String Tendiadiem;
    String Hinhanh;
    String Hinhanh1;
    String Hinhanh2;
    String Hinhanh3;
    String Mota;

    public TopPlaces(String ID, String tendiadanh, String tendiadiem, String hinhanh, String hinhanh1, String hinhanh2, String hinhanh3, String mota) {
        this.ID = ID;
        Tendiadanh = tendiadanh;
        Tendiadiem = tendiadiem;
        Hinhanh = hinhanh;
        Hinhanh1 = hinhanh1;
        Hinhanh2 = hinhanh2;
        Hinhanh3 = hinhanh3;
        Mota = mota;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTendiadanh() {
        return Tendiadanh;
    }

    public void setTendiadanh(String tendiadanh) {
        Tendiadanh = tendiadanh;
    }

    public String getTendiadiem() {
        return Tendiadiem;
    }

    public void setTendiadiem(String tendiadiem) {
        Tendiadiem = tendiadiem;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getHinhanh1() {
        return Hinhanh1;
    }

    public void setHinhanh1(String hinhanh1) {
        Hinhanh1 = hinhanh1;
    }

    public String getHinhanh2() {
        return Hinhanh2;
    }

    public void setHinhanh2(String hinhanh2) {
        Hinhanh2 = hinhanh2;
    }

    public String getHinhanh3() {
        return Hinhanh3;
    }

    public void setHinhanh3(String hinhanh3) {
        Hinhanh3 = hinhanh3;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }
}
