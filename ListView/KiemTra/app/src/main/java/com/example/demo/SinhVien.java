package com.example.demo;

public class SinhVien {
    private String Masv;
    private String HoTen;
    private String LopHP;
    private int Hinh;

    public SinhVien(String masv, String hoTen, String lopHP, int hinh) {
        Masv = masv;
        HoTen = hoTen;
        LopHP = lopHP;
        Hinh = hinh;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String masv) {
        Masv = masv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getLopHP() {
        return LopHP;
    }

    public void setLopHP(String lopHP) {
        LopHP = lopHP;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
