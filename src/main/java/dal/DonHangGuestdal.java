package dal;

import model.DonHang;
import model.DonHangGuest;
import model.KhachHang;
import model.Products;

import java.sql.*;
import java.util.ArrayList;

public class DonHangGuestdal implements interDAL<DonHangGuest>{
    @Override
    public ArrayList<DonHangGuest> selectAll() throws SQLException, ClassNotFoundException {
        ArrayList<DonHangGuest> ketQua = new ArrayList<DonHangGuest>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhangguest";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int madonhang = rs.getInt(1);
                String maproducts = rs.getString(2);
                String hovaten = rs.getString(3);
                String diaChiNhanHang = rs.getString(4);
                String sodienthoai = rs.getString(5);
                int soluong = rs.getInt(6);
                String hinhthucthanhtoan= rs.getString(7);
                String trangthai= rs.getString(8);
                double sotien= rs.getDouble(9);
                Date ngaydathang= rs.getDate(10);
                Date ngaygiaohang= rs.getDate(11);
                Products products= new Products(maproducts);
                DonHangGuest dh= new DonHangGuest(madonhang,products,hovaten,diaChiNhanHang,sodienthoai,soluong,hinhthucthanhtoan,trangthai,sotien,ngaydathang,ngaygiaohang);
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
    public DonHangGuest selectById(DonHangGuest o) throws SQLException, ClassNotFoundException {
       DonHangGuest ketQua = new DonHangGuest();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhangguest where madonhang=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,o.getMadonhang());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int madonhang = rs.getInt(1);
                String maproducts = rs.getString(2);
                String hovaten = rs.getString(3);
                String diaChiNhanHang = rs.getString(4);
                String sodienthoai = rs.getString(5);
                int soluong = rs.getInt(6);
                String hinhthucthanhtoan= rs.getString(7);
                String trangthai= rs.getString(8);
                Products products= new Products(maproducts);
                Productsdal productsdal= new Productsdal();
                products= productsdal.selectById(products);
                double sotien= rs.getDouble(9);
                Date ngaydathang= rs.getDate(10);
                Date ngaygiaohang= rs.getDate(11);
                DonHangGuest dh= new DonHangGuest(madonhang,products,hovaten,diaChiNhanHang,sodienthoai,soluong,hinhthucthanhtoan,trangthai,sotien,ngaydathang,ngaygiaohang);
                ketQua=dh;
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(DonHangGuest donHang) throws SQLException, ClassNotFoundException {
        int ketqua= 0;
        Connection con = JDBC.getConnection();
        String sql= "INSERT INTO donhangguest ( products , name , diachinhanhang , sodienthoai, soluong , hinhthucthanhtoan , trangthai , sotienthanhtoan , ngaydathang , ngaygiaohang)"+
                "VALUES (?,?,?,?,?,?,?,?,?,?)" ;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, donHang.getProducts().getId());
            st.setString(2,donHang.getHovaten());
            st.setString(3,donHang.getDiachinhanhang());
            st.setString(4,donHang.getSodienthoai());
            st.setInt(5,donHang.getSoluong());
            st.setString(6,donHang.getHinhthucthanhtoan());
            st.setString(7,donHang.getTrangthai());
            st.setDouble(8,donHang.getSotienthanhtoan());
            st.setDate(9,donHang.getNgaydathang());
            st.setDate(10,donHang.getNgaygiaohang());
            ketqua = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(DonHangGuest donHang) throws SQLException, ClassNotFoundException {
        int ketqua= 0;
        Connection con = JDBC.getConnection();
        String sql= "UPDATE donhangguest SET products=?, name=? , diachinhanhang=? , sodienthoai=?, soluong=? , hinhthucthanhtoan=? , trangthai=? , sotienthanhtoan=? , ngaydathang=?, ngaygiaohang=? where madonhang=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, donHang.getProducts().getId());
            st.setString(2,donHang.getHovaten());
            st.setString(3,donHang.getDiachinhanhang());
            st.setString(4,donHang.getSodienthoai());
            st.setInt(5,donHang.getSoluong());
            st.setString(6,donHang.getHinhthucthanhtoan());
            st.setString(7,donHang.getTrangthai());
            st.setDouble(8,donHang.getSotienthanhtoan());
            st.setDate(9,donHang.getNgaydathang());
            st.setDate(10,donHang.getNgaygiaohang());
            st.setInt(11,donHang.getMadonhang());
            ketqua = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(DonHangGuest t) throws SQLException, ClassNotFoundException {
        int kq = 0;
        Connection con = JDBC.getConnection();
        String sql = "DELETE FROM donhangguest WHERE madonhang = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getMadonhang());
            kq = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    public ArrayList<DonHangGuest> selectdate(Date fromdate, Date todate) throws SQLException, ClassNotFoundException {
        ArrayList<DonHangGuest> ketQua = new ArrayList<DonHangGuest>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhangguest where (ngaydathang<? or ngaydathang>?) and ?<? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setDate(1,fromdate);
            st.setDate(2,todate);
            st.setDate(3,fromdate);
            st.setDate(4,todate);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int madonhang = rs.getInt(1);
                String maproducts = rs.getString(2);
                String hovaten = rs.getString(3);
                String diaChiNhanHang = rs.getString(4);
                String sodienthoai = rs.getString(5);
                int soluong = rs.getInt(6);
                String hinhthucthanhtoan= rs.getString(7);
                String trangthai= rs.getString(8);
                double sotien= rs.getDouble(9);
                Date ngaydathang= rs.getDate(10);
                Date ngaygiaohang= rs.getDate(11);
                Products products= new Products(maproducts);
                DonHangGuest dh= new DonHangGuest(madonhang,products,hovaten,diaChiNhanHang,sodienthoai,soluong,hinhthucthanhtoan,trangthai,sotien,ngaydathang,ngaygiaohang);
                ketQua.add(dh);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<DonHangGuest> selectidproduct(String id) throws SQLException, ClassNotFoundException {
        ArrayList<DonHangGuest> ketQua = new ArrayList<DonHangGuest>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhangguest where products=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int madonhang = rs.getInt(1);
                String maproducts = rs.getString(2);
                String hovaten = rs.getString(3);
                String diaChiNhanHang = rs.getString(4);
                String sodienthoai = rs.getString(5);
                int soluong = rs.getInt(6);
                String hinhthucthanhtoan= rs.getString(7);
                String trangthai= rs.getString(8);
                double sotien= rs.getDouble(9);
                Date ngaydathang= rs.getDate(10);
                Date ngaygiaohang= rs.getDate(11);
                Products products= new Products(maproducts);
                DonHangGuest dh= new DonHangGuest(madonhang,products,hovaten,diaChiNhanHang,sodienthoai,soluong,hinhthucthanhtoan,trangthai,sotien,ngaydathang,ngaygiaohang);
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
