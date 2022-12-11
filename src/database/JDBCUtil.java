package database;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection myCon = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLHeThongDatHang;encrypt=false";
            String username = "sa";
            String password = "123456";

            myCon = DriverManager.getConnection(url, username, password);
            System.out.println("Connection success");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return myCon;
    }
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}