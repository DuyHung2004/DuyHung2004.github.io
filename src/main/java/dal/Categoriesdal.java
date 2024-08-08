package dal;

import model.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Categoriesdal implements interDAL<Categories>{

    @Override
    public ArrayList<Categories> selectAll() {
        ArrayList<Categories> ketqua= new ArrayList<Categories>();
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from categories";
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                int id= rs.getInt("ID");
                String name= rs.getString("name");
                String description= rs.getString("describe");
                Categories categories= new Categories(id,name,description);
                ketqua.add(categories);
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
    public Categories selectById(Categories o) {
        Categories ketqua= null;
        try {
            Connection connection= JDBC.getConnection();
            String sql= "select * from categories where id=?";
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1,o.getId());
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                int id= rs.getInt("ID");
                String name= rs.getString("name");
                String description= rs.getString("describe");
                Categories categories= new Categories(id,name,description);
                ketqua=categories;
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
    public int insert(Categories categories) {
        int ketqua=0;
        try {
            Connection con= JDBC.getConnection();
            String sql ="INSERT INTO categories (ID, name , describe)"+
                    " Values(?,?,?)";
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1,categories.getId());
            st.setString(2,categories.getName());
            st.setString(3,categories.getDescription());
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
    public int update(Categories categories) {
        int ketqua=0;
        try {
            Connection con= JDBC.getConnection();
            String sql = "UPDATE categories SET name = ?, describe = ? WHERE ID = ?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1, categories.getName());
            st.setString(2, categories.getDescription());
            st.setInt(3,categories.getId());
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
    public int delete(Categories categories) {
        int ketqua=0;
        try {
            Connection con= JDBC.getConnection();
            String sql ="delete from categories "+"where id=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1, categories.getId());
            ketqua =st.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }
}
