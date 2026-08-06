package com.healthclinic.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/healthapp";
    private static final String user = "root";
    private static final String password = "7509";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected successfully...");
        } catch (ClassNotFoundException e) {
            System.out.println("mysql driver not found...");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("connection failed...");
            e.printStackTrace();
        }

        return conn;
    }
}