package dal;

import model.DonHang;
import model.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class DonHangdal implements interDAL<DonHang>{
    @Override
    public ArrayList<DonHang> selectAll() throws SQLException, ClassNotFoundException {
        ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDH = rs.getString(1);
                String maKH = rs.getString(2);
                String trangThai = rs.getString(3);
                String hinhThucThanhToan = rs.getString(4);
                double sotienthanhtoan = rs.getDouble(5);
                Date ngayDatHang = rs.getDate(6);
                Date ngayGiaoHang = rs.getDate(7);

                KhachHang khachHang = new KhachHangdal()
                        .selectById(new KhachHang(maKH, "", "", "", "", "", null, "", null));
                DonHang dh = new DonHang(maDH, khachHang, trangThai, hinhThucThanhToan, sotienthanhtoan,ngayDatHang, ngayGiaoHang);

                ketQua.add(dh);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public DonHang selectById(DonHang o) throws SQLException, ClassNotFoundException {
        DonHang ketQua= new DonHang();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang where madonhang=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,o.getMadonhang());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDH = rs.getString(1);
                String maKH = rs.getString(2);
                String trangThai = rs.getString(3);
                String hinhThucThanhToan = rs.getString(4);
                double sotienthanhtoan = rs.getDouble(5);
                Date ngayDatHang = rs.getDate(6);
                Date ngayGiaoHang = rs.getDate(7);

                KhachHang khachHang = new KhachHangdal()
                        .selectById(new KhachHang(maKH, "", "", "", "", "", null, "", null));
                ketQua = new DonHang(maDH, khachHang, trangThai, hinhThucThanhToan , sotienthanhtoan,ngayDatHang, ngayGiaoHang);

            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(DonHang donHang) throws SQLException, ClassNotFoundException {
        int ketqua= 0;
        Connection con = JDBC.getConnection();
        String sql= "INSERT INTO donhang ( madonhang, khachHang, trangthai , hinhthucthanhtoan ,sotienthanhtoan , ngaydathang , ngaygiaohang )"+
                "VALUES (?,?,?,?,?,?,?)" ;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,donHang.getMadonhang());
            st.setString(2, donHang.getKhachHang().getMakhachhang());
            st.setString(3,donHang.getTrangthai());
            st.setString(4,donHang.getHinhthucthanhtoan());
            st.setDouble(5,donHang.getSotienthanhtoan());
            st.setDate(6,donHang.getNgaydathang());
            st.setDate(7,donHang.getNgaygiaohang());
            ketqua = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(DonHang t) throws SQLException, ClassNotFoundException {
        int kq = 0;
        Connection con = JDBC.getConnection();

        String sql = "UPDATE donhang" + " SET " + "khachhang=?" + ",trangthai=?" + ",hinhthucthanhtoan=?"  + ",sotienthanhtoan=?" + ",ngaydathang=?"
                + ",ngaygiaohang=?" + " WHERE madonhang=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getKhachHang().getMakhachhang());
            st.setString(2, t.getTrangthai());
            st.setString(3, t.getHinhthucthanhtoan());
            st.setDouble(4, t.getSotienthanhtoan());
            st.setDate(5,  t.getNgaydathang());
            st.setDate(6,  t.getNgaygiaohang());
            st.setString(7, t.getMadonhang());

            kq = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(DonHang t) throws SQLException, ClassNotFoundException {
        int kq = 0;
        Connection con = JDBC.getConnection();
        String sql = "DELETE FROM donhang WHERE madonhang = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMadonhang());
            kq = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    public ArrayList<DonHang> selectAllbyid(String id) throws SQLException, ClassNotFoundException {
        ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang where khachhang=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDH = rs.getString(1);
                String maKH = rs.getString(2);
                String trangThai = rs.getString(3);
                String hinhThucThanhToan = rs.getString(4);
                double sotienthanhtoan = rs.getDouble(5);
                Date ngayDatHang = rs.getDate(6);
                Date ngayGiaoHang = rs.getDate(7);

                KhachHang khachHang = new KhachHangdal()
                        .selectById(new KhachHang(maKH, "", "", "", "", "", null, "", null));
                DonHang dh = new DonHang(maDH, khachHang, trangThai, hinhThucThanhToan, sotienthanhtoan,ngayDatHang, ngayGiaoHang);

                ketQua.add(dh);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<DonHang> selectdate(String id, Date fromdate, Date todate) throws SQLException, ClassNotFoundException {
        ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang where khachhang=? and ngaydathang>=? and ngaydathang<=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            st.setDate(2,fromdate);
            st.setDate(3,todate);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDH = rs.getString(1);
                String maKH = rs.getString(2);
                String trangThai = rs.getString(3);
                String hinhThucThanhToan = rs.getString(4);
                double sotienthanhtoan = rs.getDouble(5);
                Date ngayDatHang = rs.getDate(6);
                Date ngayGiaoHang = rs.getDate(7);

                KhachHang khachHang = new KhachHangdal()
                        .selectById(new KhachHang(maKH, "", "", "", "", "", null, "", null));
                DonHang dh = new DonHang(maDH, khachHang, trangThai, hinhThucThanhToan, sotienthanhtoan,ngayDatHang, ngayGiaoHang);

                ketQua.add(dh);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }
    public KhachHang selectkhachhang(String id) throws SQLException, ClassNotFoundException {
        KhachHang ketQua= new KhachHang();
        Connection con = JDBC.getConnection();
        String sql = "SELECT khachhang FROM donhang where madonhang=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH= rs.getString(1);

                KhachHang khachHang = new KhachHangdal()
                        .selectById(new KhachHang(maKH, "", "", "", "", "", null, "", null));
                ketQua = khachHang;
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<DonHang> selectdatequanly( Date fromdate, Date todate) throws SQLException, ClassNotFoundException {
        ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang where (ngaydathang<? or ngaydathang>?) and ?<=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setDate(1,fromdate);
            st.setDate(2,todate);
            st.setDate(3,fromdate);
            st.setDate(4,todate);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDH = rs.getString(1);
                String maKH = rs.getString(2);
                String trangThai = rs.getString(3);
                String hinhThucThanhToan = rs.getString(4);
                double sotienthanhtoan = rs.getDouble(5);
                Date ngayDatHang = rs.getDate(6);
                Date ngayGiaoHang = rs.getDate(7);
                KhachHang khachHang = new KhachHangdal()
                        .selectById(new KhachHang(maKH, "", "", "", "", "", null, "", null));
                DonHang dh = new DonHang(maDH, khachHang, trangThai, hinhThucThanhToan, sotienthanhtoan,ngayDatHang, ngayGiaoHang);

                ketQua.add(dh);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<DonHang> selectidkhachhang( String id) throws SQLException, ClassNotFoundException {
        ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang where khachhang != ? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDH = rs.getString(1);
                String maKH = rs.getString(2);
                String trangThai = rs.getString(3);
                String hinhThucThanhToan = rs.getString(4);
                double sotienthanhtoan = rs.getDouble(5);
                Date ngayDatHang = rs.getDate(6);
                Date ngayGiaoHang = rs.getDate(7);
                KhachHang khachHang = new KhachHangdal()
                        .selectById(new KhachHang(maKH, "", "", "", "", "", null, "", null));
                DonHang dh = new DonHang(maDH, khachHang, trangThai, hinhThucThanhToan, sotienthanhtoan,ngayDatHang, ngayGiaoHang);

                ketQua.add(dh);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

}
