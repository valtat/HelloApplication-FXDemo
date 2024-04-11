package org.example.helloapplication;

import java.sql.*;

public class MysqlConn {
    private static final String url = "jdbc:mysql://localhost:3306/fxdemo";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
