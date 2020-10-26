package com.productShop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "5340654";


    private DBConnection() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed())
                return connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.getMessage();
        }
        return connection;
    }
}