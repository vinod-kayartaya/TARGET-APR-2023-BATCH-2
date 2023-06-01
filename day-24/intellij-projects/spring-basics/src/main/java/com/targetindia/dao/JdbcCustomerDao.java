package com.targetindia.dao;

import lombok.Setter;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Setter
public class JdbcCustomerDao implements CustomerDao {

    // depends on a connection pool
    // in Java connection pool is represented by an interface javax.sql.DataSource
    // provides a function to get a connection `public Connection getConnection()`
    // There are many implementations of DataSource. Popular one is from Apache called BasicDataSource

    private DataSource dataSource; // defaults to null



    @SneakyThrows
    @Override
    public long count() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) from customers");
        ) {
            rs.next();
            return rs.getLong(1);
        }
    }
}
