package com.qqq.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private static final String DRIVER = "java.sql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/domino";
    private static final String USER = "root";
    private static final String PASSWORD = "vladvol";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
