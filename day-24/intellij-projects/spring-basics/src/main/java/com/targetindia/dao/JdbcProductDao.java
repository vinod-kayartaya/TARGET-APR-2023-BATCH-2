package com.targetindia.dao;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
@Component("dao2")
@Setter
public class JdbcProductDao implements ProductDao {

    private String driverClassName;
    private String url;
    private String user;
    private String password;

    public JdbcProductDao() {
        log.trace("JdbcProductDao instantiated");
    }

    @SneakyThrows // convert any checked exceptions from this function to unchecked exceptions
    private Connection createConnection() {
        Class.forName(driverClassName);
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    @SneakyThrows
    public long count() {
        try (
                Connection conn = this.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) from products");
        ) {
            rs.next();
            return rs.getLong(1);
        } // closes all resources opened in the try() block
    }
}
