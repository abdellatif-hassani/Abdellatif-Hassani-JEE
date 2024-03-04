package ma.enset.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T, U> {
    List<T> getData() throws SQLException;
    void add(T o) throws SQLException;
}
