package dal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface interDAL<T> {
    public ArrayList<T> selectAll() throws SQLException, ClassNotFoundException;
    public T selectById(T o) throws SQLException, ClassNotFoundException;
    public int insert(T t) throws SQLException, ClassNotFoundException;
    public int update(T t) throws SQLException, ClassNotFoundException;
    public int delete(T t) throws SQLException, ClassNotFoundException;
}
