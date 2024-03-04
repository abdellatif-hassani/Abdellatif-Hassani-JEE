package ma.enset.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonDB {
    private static Connection connection;
    static {
        try {
            String url = "jdbc:mysql://localhost:3306/db2";
            String username="root";
            String passwd="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, passwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
