package model;

public class ChiTietDonHang {
    private String machitietdonhang;
    private DonHang donhang;
    private Products products;
    private int soluong;
    private double giaban;
    private double tongTien;
    private String diachinhanhang;
    public ChiTietDonHang(){
    }

    public ChiTietDonHang(String machitietdonhang, DonHang donhang, Products products, int soluong, double giaban, double tongTien) {
        this.machitietdonhang = machitietdonhang;
        this.donhang = donhang;
        this.products = products;
        this.soluong = soluong;
        this.giaban = giaban;
        this.tongTien = tongTien;
    }

    public ChiTietDonHang(String machitietdonhang, DonHang donhang, Products products, int soluong, double giaban, double tongTien, String diachinhanhang) {
        this.machitietdonhang = machitietdonhang;
        this.donhang = donhang;
        this.products = products;
        this.soluong = soluong;
        this.giaban = giaban;
        this.tongTien = tongTien;
        this.diachinhanhang = diachinhanhang;
    }

    public String getMachitietdonhang() {
        return machitietdonhang;
    }

    public void setMachitietdonhang(String machitietdonhang) {
        this.machitietdonhang = machitietdonhang;
    }

    public DonHang getDonhang() {
        return donhang;
    }

    public void setDonhang(DonHang donhang) {
        this.donhang = donhang;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getDiachinhanhang() {
        return diachinhanhang;
    }

    public void setDiachinhanhang(String diachinhanhang) {
        this.diachinhanhang = diachinhanhang;
    }
}
