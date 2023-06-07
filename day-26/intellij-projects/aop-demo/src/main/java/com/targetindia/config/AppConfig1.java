package com.targetindia.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
@EnableAspectJAutoProxy // ask spring to scan the container for @Aspect beans and create a proxy based on pointcuts
@ComponentScan(basePackages = {"com.targetindia.dao", "com.targetindia.aop"})
public class AppConfig1 {
    @Value("${jdbc.connection.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.connection.url}")
    private String url;
    @Value("${jdbc.connection.user}")
    private String user;
    @Value("${jdbc.connection.password}")
    private String password;

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

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) { // DI
        return new JdbcTemplate(dataSource); // wiring, manually
    }
}
