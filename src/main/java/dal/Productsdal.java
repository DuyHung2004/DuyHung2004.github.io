package dal;

import model.Categories;
import model.Products;

import java.sql.*;
import java.util.ArrayList;

public class Productsdal implements interDAL<Products> {
    @Override
    public ArrayList<Products> selectAll() {
        ArrayList<Products> ketqua= new ArrayList<Products>();
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from products";
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String id= rs.getString("ID");
                String name= rs.getString("name");
                int quantit= rs.getInt("quantity");
                float price= rs.getFloat("price");
                Date date= rs.getDate("releaseDate");
                String describe= rs.getString("describe");
                String image= rs.getString("image");
                int cid= rs.getInt("cid");
                Products products= new Products(id,name,quantit,price,date,describe,image,cid);
                ketqua.add(products);
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
    public Products selectById(Products o) {
        Products ketqua= new Products();
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from products where id=?";
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1,o.getId());
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String id= rs.getString("id");
                String name= rs.getString("name");
                int quantit= rs.getInt("quantity");
                float price= rs.getFloat("price");
                Date date= rs.getDate("releaseDate");
                String describe= rs.getString("describe");
                String image= rs.getString("image");
                int cid= rs.getInt("cid");
                Products products= new Products(id,name,quantit,price,date,describe,image,cid);
                ketqua=products;
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
    public int insert(Products products) {
        int ketqua=0;
        try {
            Connection con= JDBC.getConnection();
            String sql ="INSERT INTO products (ID , name , quantity , price , releaseDate , describe , image , cid )"+
                    " Values(?,?,?,?,?,?,?,?)";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,products.getId());
            st.setString(2,products.getName());
            st.setInt(3,products.getQuantity());
            st.setFloat(4,products.getPrice());
            st.setDate(5,products.getDate());
            st.setString(6,products.getDescription());
            st.setString(7,products.getImage());
            st.setInt(8,products.getCid());
            ketqua =st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int update(Products products) {
        int ketqua=0;
        try {
            Connection con= JDBC.getConnection();
            String sql ="UPDATE products SET name=?, quantity= ?, price= ?, releaseDate= ?, describe= ?, image= ?, cid= ? where ID= ? ";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,products.getName());
            st.setInt(2,products.getQuantity());
            st.setFloat(3,products.getPrice());
            st.setDate(4,products.getDate());
            st.setString(5,products.getDescription());
            st.setString(6,products.getImage());
            st.setInt(7,products.getCid());
            st.setString(8,products.getId());
            ketqua =st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int delete(Products products) {
        int ketqua=0;
        try {
            Connection con= JDBC.getConnection();
            String sql ="delete from products "+"where id=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1, products.getId());
            ketqua =st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }
    public int updateimage(String image,String id) throws SQLException, ClassNotFoundException {
        int ketqua=0;
        Connection con= JDBC.getConnection();
        String sql ="UPDATE products SET image=? where id=? ";
        PreparedStatement st= con.prepareStatement(sql);
        st.setString(1,image);
        st.setString(2,id);
        ketqua =st.executeUpdate();
        JDBC.closeConnection(con);
        return ketqua;
    }
    public ArrayList<Products> selectcid(int cid1) {
        ArrayList<Products> ketqua= new ArrayList<Products>();
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from products where cid=?";
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1,cid1);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                String id= rs.getString("ID");
                String name= rs.getString("name");
                int quantit= rs.getInt("quantity");
                float price= rs.getFloat("price");
                Date date= rs.getDate("releaseDate");
                String describe= rs.getString("describe");
                String image= rs.getString("image");
                int cid= rs.getInt("cid");
                Products products= new Products(id,name,quantit,price,date,describe,image,cid);
                ketqua.add(products);
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
