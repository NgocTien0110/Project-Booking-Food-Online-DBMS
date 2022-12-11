package Main;

import database.JDBCUtil;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        JDBCUtil.closeConnection(connection);
        System.out.println(connection);

    }
}
