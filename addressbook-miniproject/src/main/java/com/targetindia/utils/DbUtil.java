package com.targetindia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {
    private static ResourceBundle rb;
    private DbUtil() {
    }

    static {
        rb  = ResourceBundle.getBundle("jdbc-info");
    }

    public static Connection createConnection() throws RuntimeException{
        String url = rb.getString("jdbc.connection.url");
        String user = rb.getString("jdbc.connection.user");
        String password = rb.getString("jdbc.connection.password");
        // String driverClassName = rb.getString("jdbc.connection.driverClassName");

        // load the driverClass represented by the variable driverClassName (not required since JDBC 4)
        try {
            // Class.forName(driverClassName);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e); // convert Checked exception to Unchecked exception
        }
    }
}
