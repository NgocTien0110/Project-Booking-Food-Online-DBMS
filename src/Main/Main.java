package Main;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myCon = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLHeThongDatHang;encrypt=false";
            String username = "sa";
            String password = "123456";

            myCon = DriverManager.getConnection(url, username, password);
            System.out.println("Connection success");
            myStmt = myCon.createStatement();
            String sql =String.format("select * from TaiKhoan");
            myRs = myStmt.executeQuery(sql);
            while(myRs.next()) {
                String MaTaiKhoan = myRs.getString("MaTaiKhoan");
                String TenTaiKhoan = myRs.getString("TenTaiKhoan");
                System.out.println(MaTaiKhoan + "----" + TenTaiKhoan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}