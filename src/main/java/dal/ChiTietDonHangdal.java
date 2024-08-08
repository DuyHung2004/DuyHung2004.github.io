package dal;

import model.Categories;
import model.ChiTietDonHang;
import model.DonHang;
import model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietDonHangdal implements interDAL<ChiTietDonHang>{
    @Override
    public ArrayList<ChiTietDonHang> selectAll() throws SQLException, ClassNotFoundException {
        ArrayList<ChiTietDonHang> ketqua= new ArrayList<ChiTietDonHang>();
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from chitietdonhang";
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String machitietdonhang= rs.getString(1);
                String madonkhang= rs.getString(2);
                String maproducts= rs.getString(3);
                int soluong=rs.getInt(4);
                double giaban= rs.getDouble(5);
                double tongtien= rs.getDouble(6);
                DonHang donHang= new DonHang(madonkhang);
                Productsdal productsdal= new Productsdal();
                Products products= productsdal.selectById(new Products(maproducts));
                ChiTietDonHang chiTietDonHang= new ChiTietDonHang(machitietdonhang,donHang,products,soluong,giaban,tongtien);
                ketqua.add(chiTietDonHang);
            }
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public ChiTietDonHang selectById(ChiTietDonHang o) throws SQLException, ClassNotFoundException {
        ChiTietDonHang ketqua= new ChiTietDonHang();
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from chitietdonhang";
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String machitietdonhang= rs.getString(1);
                String madonkhang= rs.getString(2);
                String maproducts= rs.getString(3);
                int soluong=rs.getInt(4);
                double giaban= rs.getDouble(5);
                double tongtien= rs.getDouble(6);
                DonHang donHang= new DonHang(madonkhang);
                Productsdal productsdal= new Productsdal();
                Products products= productsdal.selectById(new Products(maproducts));
                ChiTietDonHang chiTietDonHang= new ChiTietDonHang(machitietdonhang,donHang,products,soluong,giaban,tongtien);
                ketqua= chiTietDonHang;
            }
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int insert(ChiTietDonHang t) throws SQLException, ClassNotFoundException {
        int ketQua = 0;
        try {
            Connection con = JDBC.getConnection();
            String sql = "INSERT INTO chitietdonhang (machitietdonhang, donhang,products, soluong, giaban,tongTien,diachinhanhang) "
                    + " VALUES (?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMachitietdonhang());
            st.setString(2, t.getDonhang().getMadonhang());
            st.setString(3, t.getProducts().getId());
            st.setDouble(4, t.getSoluong());
            st.setDouble(5, t.getGiaban());
            st.setDouble(6, t.getTongTien());
            st.setString(7,t.getDiachinhanhang());
            ketQua = st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(ChiTietDonHang t) throws SQLException, ClassNotFoundException {
        int ketQua = 0;
        try {
            Connection con = JDBC.getConnection();
            String sql = "UPDATE chitietdonhang SET donhang=? ,products=? , soluong=? , giaban=?,tongTien=? where machitietdonhang=?) ";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getDonhang().getMadonhang());
            st.setString(2, t.getProducts().getId());
            st.setDouble(3, t.getSoluong());
            st.setDouble(4, t.getGiaban());
            st.setDouble(5, t.getTongTien());
            st.setString(6,t.getMachitietdonhang());
            ketQua = st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(ChiTietDonHang t) throws SQLException, ClassNotFoundException {
        int ketQua = 0;
        try {
            Connection con = JDBC.getConnection();
            String sql = "DELETE from chitietdonhang " + " WHERE machitietdonhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMachitietdonhang());
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
    public ChiTietDonHang selectBymadonhang(String madonhang) throws SQLException, ClassNotFoundException {
        ChiTietDonHang ketqua= new ChiTietDonHang();
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from chitietdonhang where donhang=?";
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1, madonhang);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String machitietdonhang= rs.getString(1);
                String madonkhang= rs.getString(2);
                String maproducts= rs.getString(3);
                int soluong=rs.getInt(4);
                double giaban= rs.getDouble(5);
                double tongtien= rs.getDouble(6);
                String diachinhanhang= rs.getString(7);
                DonHang donHang= new DonHang(madonkhang);
                Productsdal productsdal= new Productsdal();
                Products products= productsdal.selectById(new Products(maproducts));
                ChiTietDonHang chiTietDonHang= new ChiTietDonHang(machitietdonhang,donHang,products,soluong,giaban,tongtien,diachinhanhang);
                ketqua= chiTietDonHang;
            }
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }
    public ArrayList<ChiTietDonHang> selectbyproduct(String id) throws SQLException, ClassNotFoundException {
        ArrayList<ChiTietDonHang> ketqua = new ArrayList<ChiTietDonHang>();
        try {
            Connection connection = JDBC.getConnection();
            String sql = "select * from chitietdonhang where products=? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String machitietdonhang = rs.getString(1);
                String madonkhang = rs.getString(2);
                String maproducts = rs.getString(3);
                int soluong = rs.getInt(4);
                double giaban = rs.getDouble(5);
                double tongtien = rs.getDouble(6);
                DonHangdal donHangdal= new DonHangdal();
                DonHang donHang = new DonHang(madonkhang);
                donHang=donHangdal.selectById(donHang);
                Productsdal productsdal = new Productsdal();
                Products products = productsdal.selectById(new Products(maproducts));
                ChiTietDonHang chiTietDonHang = new ChiTietDonHang(machitietdonhang, donHang, products, soluong, giaban, tongtien);
                ketqua.add(chiTietDonHang);
            }
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }
}
