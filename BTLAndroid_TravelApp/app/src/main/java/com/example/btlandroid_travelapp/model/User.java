package com.example.btlandroid_travelapp.model;

public class User {
        int ID;
        String Tendangnhap;
        String Email;
        String Sodienthoai;
        String Matkhau;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTendangnhap() {
        return Tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        Tendangnhap = tendangnhap;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        Sodienthoai = sodienthoai;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String matkhau) {
        Matkhau = matkhau;
    }
}
