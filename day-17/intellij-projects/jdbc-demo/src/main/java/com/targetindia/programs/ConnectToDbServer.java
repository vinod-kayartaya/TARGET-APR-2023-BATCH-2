package com.targetindia.programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDbServer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:1234/vinoddb";
//        String url = "jdbc:mysql://localhost/testdb";
        String user = "root";
        String password = "Welcome#123";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
        ) {
            System.out.printf("conn is an object of '%s' class", conn.getClass().getName());
        } // conn.close() is called here
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
