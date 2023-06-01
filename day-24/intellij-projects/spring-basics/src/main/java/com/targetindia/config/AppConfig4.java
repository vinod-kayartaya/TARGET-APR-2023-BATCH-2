package com.targetindia.config;

import com.targetindia.dao.JdbcCustomerDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig4 {

    @Value("${jdbc.connection.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.connection.url}")
    private String url;
    @Value("${jdbc.connection.user}")
    private String user;
    @Value("${jdbc.connection.password}")
    private String password;

    // Since spring calls this function below, spring has to pass a valid
    // DataSource object as argument. This is called dependency injection (one of many)
    @Bean
    public JdbcCustomerDao customerDao(DataSource dataSource){ // dependency injection
        log.trace("dataSource is an instance of {}", dataSource.getClass());
        JdbcCustomerDao dao = new JdbcCustomerDao();
        dao.setDataSource(dataSource); // manual wiring
        return dao;
    }

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(this.driverClassName);
        bds.setUrl(this.url);
        bds.setUsername(this.user);
        bds.setPassword(this.password);
        bds.setInitialSize(5);
        bds.setMaxTotal(50);
        bds.setMaxWaitMillis(100);

        return bds;
    }
}
