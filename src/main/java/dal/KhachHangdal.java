package dal;

import model.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangdal implements interDAL<KhachHang>{

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
        try {
            Connection con = JDBC.getConnection();

            String sql = "SELECT * FROM khachhang";
            PreparedStatement st = con.prepareStatement(sql);

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String maKhacHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hoten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                String maxacthuc=rs.getString("maxacthuc");
                Date thoigianhieuluc=rs.getDate("thoigianhieuluc");
                Boolean trangthaixacthuc= rs.getBoolean("trangthaixacthuc");
                KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, ngaySinh, soDienThoai, email, maxacthuc,thoigianhieuluc,trangthaixacthuc);
                ketQua.add(kh);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public KhachHang selectById(KhachHang o) {
        KhachHang ketQua = null;
        try {

            Connection con = JDBC.getConnection();
            if (con!=null){
                String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, o.getMakhachhang());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String maKhacHang = rs.getString("makhachhang");
                    String tenDangNhap = rs.getString("tendangnhap");
                    String matKhau = rs.getString("matkhau");
                    String hoVaTen = rs.getString("hoten");
                    String gioiTinh = rs.getString("gioitinh");
                    String diaChi = rs.getString("diachi");
                    Date ngaySinh = rs.getDate("ngaysinh");
                    String soDienThoai = rs.getString("sodienthoai");
                    String email = rs.getString("email");
                    String maxacthuc=rs.getString("maxacthuc");
                    Date thoigianhieuluc=rs.getDate("thoigianhieuluc");
                    Boolean trangthaixacthuc= rs.getBoolean("trangthaixacthuc");

                    ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, ngaySinh, soDienThoai, email, maxacthuc,thoigianhieuluc,trangthaixacthuc);
                } }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int insert(KhachHang t) {
        int ketQua = 0;
        try {
            Connection con = JDBC.getConnection();
            if (con != null) {
                String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hoten, gioitinh, diachi, ngaysinh, sodienthoai, email) "
                        + " VALUES (?,?,?,?,?,?,?,?,?)";

                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1,t.getMakhachhang());
                st.setString(2, t.getTendangnhap());
                st.setString(3, t.getMatkhau());
                st.setString(4, t.getHoten());
                st.setString(5, t.getGioitinh());
                st.setString(6, t.getDiachi());
                st.setDate(7, t.getNgaysinh());
                st.setString(8, t.getSodienthoai());
                st.setString(9, t.getEmail());
                ketQua = st.executeUpdate();
                JDBC.closeConnection(con);}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public int update(KhachHang t) {
        int ketQua = 0;
        try {
            Connection con = JDBC.getConnection();
            String sql = "UPDATE khachhang " + " SET " + " tendangnhap=?" + ", matkhau=?" + ", hoten=?" + ", gioitinh=?"
                    + ", diachi=?" + ", ngaysinh=?" + ", sodienthoai=?"
                    + ", email=?" + ", trangthaixacthuc=? "  + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTendangnhap());
            st.setString(2, t.getMatkhau());
            st.setString(3, t.getHoten());
            st.setString(4, t.getGioitinh());
            st.setString(5, t.getDiachi());
            st.setDate(6, t.getNgaysinh());
            st.setString(7, t.getSodienthoai());
            st.setString(8, t.getEmail());
            st.setBoolean(9,t.isTrangthaixacthuc());
            st.setString(10, t.getMakhachhang());
            ketQua = st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public int delete(KhachHang t) {
        int ketQua = 0;
        try {
            Connection con = JDBC.getConnection();
            String sql = "DELETE from khachhang " + " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMakhachhang());
            System.out.println(sql);
            ketQua = st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }
    public boolean kiemtratendangnhap(String t) {
        boolean ketQua = false;
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM khachhang WHERE tendangnhap=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua= true;
                break;
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    public  KhachHang selectdangnhap(KhachHang khachHang){
        KhachHang ketqua = null;
        try {
            Connection con = JDBC.getConnection();
            if (con!=null){
                String sql = "SELECT * FROM khachhang WHERE tendangnhap=? and matkhau=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, khachHang.getTendangnhap());
                st.setString(2,khachHang.getMatkhau());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String maKhacHang = rs.getString("makhachhang");
                    String tenDangNhap = rs.getString("tendangnhap");
                    String matKhau = rs.getString("matkhau");
                    String hoVaTen = rs.getString("hoten");
                    String gioiTinh = rs.getString("gioitinh");
                    String diaChi = rs.getString("diachi");
                    Date ngaySinh = rs.getDate("ngaysinh");
                    String soDienThoai = rs.getString("sodienthoai");
                    String email = rs.getString("email");

                    ketqua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, ngaySinh, soDienThoai, email);
                } }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ketqua);
        return ketqua;
    }
    public boolean changepassword(KhachHang t) {
        int ketQua = 0;
        try {
            Connection con = JDBC.getConnection();

            String sql = "UPDATE khachhang " + " SET " + " matkhau=? " +  "WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMatkhau());
            st.setString(2, t.getMakhachhang());
            ketQua = st.executeUpdate();

            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ketQua>0;
    }
    public KhachHang selectBytendangnhap(String tendangnhap) {
        KhachHang ketQua = null;
        try {

            Connection con = JDBC.getConnection();
            if (con!=null){
                String sql = "SELECT * FROM khachhang WHERE tendangnhap=? ";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, tendangnhap);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String maKhacHang = rs.getString("makhachhang");
                    String tenDangNhap = rs.getString("tendangnhap");
                    String matKhau = rs.getString("matkhau");
                    String hoVaTen = rs.getString("hoten");
                    String gioiTinh = rs.getString("gioitinh");
                    String diaChi = rs.getString("diachi");
                    Date ngaySinh = rs.getDate("ngaysinh");
                    String soDienThoai = rs.getString("sodienthoai");
                    String email = rs.getString("email");
                    String maxacthuc=rs.getString("maxacthuc");
                    Date thoigianhieuluc=rs.getDate("thoigianhieuluc");
                    Boolean trangthaixacthuc= rs.getBoolean("trangthaixacthuc");

                    ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, ngaySinh, soDienThoai, email, maxacthuc,thoigianhieuluc,trangthaixacthuc);
                } }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}
