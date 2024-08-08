package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
    private String madonhang;
    private KhachHang khachHang;
    private String trangthai;
    private String hinhthucthanhtoan;
    private double sotienthanhtoan;
    private Date ngaydathang;
    private Date ngaygiaohang;

    public DonHang(String madonhang, KhachHang khachHang, String trangthai, String hinhthucthanhtoan,double sotienthanhtoan, Date ngaydathang, Date ngaygiaohang) {
        this.madonhang = madonhang;
        this.khachHang = khachHang;
        this.trangthai = trangthai;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.sotienthanhtoan= sotienthanhtoan;
        this.ngaydathang = ngaydathang;
        this.ngaygiaohang = ngaygiaohang;
    }
    public DonHang (KhachHang khachHang, String trangthai, String hinhthucthanhtoan , double sotienthanhtoan, Date ngaydathang, Date ngaygiaohang) {
        this.khachHang = khachHang;
        this.trangthai = trangthai;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.sotienthanhtoan = sotienthanhtoan;
        this.ngaydathang = ngaydathang;
        this.ngaygiaohang = ngaygiaohang;
    }

    public DonHang(){
    }

    public DonHang(String madonhang) {
        this.madonhang = madonhang;
    }

    public String getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(String madonhang) {
        this.madonhang = madonhang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
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

    public double getSotienthanhtoan() {
        return sotienthanhtoan;
    }

    public void setSotienthanhtoan(double sotienthanhtoan) {
        this.sotienthanhtoan = sotienthanhtoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonHang donHang = (DonHang) o;
        return  Objects.equals(madonhang, donHang.madonhang) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(madonhang);
    }

}
