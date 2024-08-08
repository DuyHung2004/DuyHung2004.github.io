package model;

import java.sql.Date;
import java.util.Objects;

public class DonHangGuest {
    private int madonhang;
    private Products products;
    private String hovaten;
    private String diachinhanhang;
    private String sodienthoai;
    private int soluong;
    private String hinhthucthanhtoan;
    private String trangthai;
    private double sotienthanhtoan;
    private Date ngaydathang;
    private Date ngaygiaohang;

    public DonHangGuest(int madonhang, Products products, String hovaten, String diachinhanhang, String sodienthoai, int soluong, String hinhthucthanhtoan, String trangthai) {
        this.madonhang = madonhang;
        this.products = products;
        this.hovaten = hovaten;
        this.diachinhanhang = diachinhanhang;
        this.sodienthoai = sodienthoai;
        this.soluong = soluong;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.trangthai = trangthai;
    }

    public DonHangGuest(int madonhang, Products products, String hovaten, String diachinhanhang, String sodienthoai, int soluong, String hinhthucthanhtoan, String trangthai, double sotienthanhtoan, Date ngaydathang, Date ngaygiaohang) {
        this.madonhang = madonhang;
        this.products = products;
        this.hovaten = hovaten;
        this.diachinhanhang = diachinhanhang;
        this.sodienthoai = sodienthoai;
        this.soluong = soluong;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.trangthai = trangthai;
        this.sotienthanhtoan = sotienthanhtoan;
        this.ngaydathang = ngaydathang;
        this.ngaygiaohang = ngaygiaohang;
    }

    public DonHangGuest(Products products, String hovaten, String diachinhanhang, String sodienthoai, int soluong, String hinhthucthanhtoan, String trangthai, double sotienthanhtoan) {
        this.products = products;
        this.hovaten = hovaten;
        this.diachinhanhang = diachinhanhang;
        this.sodienthoai = sodienthoai;
        this.soluong = soluong;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.trangthai = trangthai;
        this.sotienthanhtoan = sotienthanhtoan;
    }

    public DonHangGuest(int madonhang) {
        this.madonhang = madonhang;
    }

    public DonHangGuest(Products products, String hovaten, String diachinhanhang, String sodienthoai, int soluong, String hinhthucthanhtoan, String trangthai) {
        this.products = products;
        this.hovaten = hovaten;
        this.diachinhanhang = diachinhanhang;
        this.sodienthoai = sodienthoai;
        this.soluong = soluong;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.trangthai = trangthai;
    }

    public DonHangGuest() {
    }

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getDiachinhanhang() {
        return diachinhanhang;
    }

    public void setDiachinhanhang(String diachinhanhang) {
        this.diachinhanhang = diachinhanhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public double getSotienthanhtoan() {
        return sotienthanhtoan;
    }

    public void setSotienthanhtoan(double sotienthanhtoan) {
        this.sotienthanhtoan = sotienthanhtoan;
    }

    public DonHangGuest(int madonhang, Products products, String hovaten, String diachinhanhang, String sodienthoai, int soluong, String hinhthucthanhtoan, String trangthai, double sotienthanhtoan) {
        this.madonhang = madonhang;
        this.products = products;
        this.hovaten = hovaten;
        this.diachinhanhang = diachinhanhang;
        this.sodienthoai = sodienthoai;
        this.soluong = soluong;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.trangthai = trangthai;
        this.sotienthanhtoan = sotienthanhtoan;
    }

    public Date getNgaydathang() {
        return ngaydathang;
    }

    public void setNgaydathang(Date ngaydathang) {
        this.ngaydathang = ngaydathang;
    }

    public Date getNgaygiaohang() {
        return ngaygiaohang;
    }

    public void setNgaygiaohang(Date ngaygiaohang) {
        this.ngaygiaohang = ngaygiaohang;
    }

    public DonHangGuest(Products products, String hovaten, String diachinhanhang, String sodienthoai, int soluong, String hinhthucthanhtoan, String trangthai, double sotienthanhtoan, Date ngaydathang, Date ngaygiaohang) {
        this.products = products;
        this.hovaten = hovaten;
        this.diachinhanhang = diachinhanhang;
        this.sodienthoai = sodienthoai;
        this.soluong = soluong;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.trangthai = trangthai;
        this.sotienthanhtoan = sotienthanhtoan;
        this.ngaydathang = ngaydathang;
        this.ngaygiaohang = ngaygiaohang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonHangGuest that = (DonHangGuest) o;
        return madonhang == that.madonhang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(madonhang);
    }
}
