package model;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
    private String makhachhang;
    private String tendangnhap;
    private String matkhau;
    private String hoten;
    private String gioitinh;
    private String diachi;
    private Date ngaysinh;
    private String sodienthoai;
    private  String email;
    private String maxacthuc;
    private Date thoigianhieuluc;
    private boolean trangthaixacthuc;

    public KhachHang(){
    }

    public KhachHang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public KhachHang(String makhachhang, String tendangnhap, String matkhau, String hoten, String gioitinh, String diachi, Date ngaysinh, String sodienthoai, String email) {
        this.makhachhang = makhachhang;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.email = email;
    }

    public KhachHang(String makhachhang, String tendangnhap, String matkhau, String hoten, String gioitinh, String diachi, Date ngaysinh, String sodienthoai, String email, String maxacthuc, Date thoigianhieuluc, boolean trangthaixacthuc) {
        this.makhachhang = makhachhang;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.maxacthuc = maxacthuc;
        this.thoigianhieuluc = thoigianhieuluc;
        this.trangthaixacthuc = trangthaixacthuc;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaxacthuc() {
        return maxacthuc;
    }

    public void setMaxacthuc(String maxacthuc) {
        this.maxacthuc = maxacthuc;
    }

    public Date getThoigianhieuluc() {
        return thoigianhieuluc;
    }

    public void setThoigianhieuluc(Date thoigianhieuluc) {
        this.thoigianhieuluc = thoigianhieuluc;
    }

    public boolean isTrangthaixacthuc() {
        return trangthaixacthuc;
    }

    public void setTrangthaixacthuc(boolean trangthaixacthuc) {
        this.trangthaixacthuc = trangthaixacthuc;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "makhachhang='" + makhachhang + '\'' +
                ", tendangnhap='" + tendangnhap + '\'' +
                ", matkhau='" + matkhau + '\'' +
                ", hoten='" + hoten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", diachi='" + diachi + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", sodienthoai='" + sodienthoai + '\'' +
                ", email='" + email + '\'' +
                ", maxacthuc='" + maxacthuc + '\'' +
                ", thoigianhieuluc=" + thoigianhieuluc +
                ", trangthaixacthuc=" + trangthaixacthuc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhachHang khachHang = (KhachHang) o;
        return Objects.equals(makhachhang, khachHang.makhachhang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(makhachhang);
    }
}
