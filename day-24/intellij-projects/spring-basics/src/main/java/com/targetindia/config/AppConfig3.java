package com.targetindia.config;

import com.targetindia.dao.JdbcProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration // for basic applications, this is not required, but for more complex apps the
// absence of this will have negative implications
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig3 {

    // When spring creates an object of this class, it will also load the properties from
    // the given file (@PropertySource("classpath:jdbc-info.properties")), and injects
    // the variables given below using the property keys
    @Value("${jdbc.connection.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.connection.url}")
    private String url;
    @Value("${jdbc.connection.user}")
    private String user;
    @Value("${jdbc.connection.password}")
    private String password;

    @Bean
    public JdbcProductDao dao1(){
        JdbcProductDao dao = new JdbcProductDao();
        dao.setDriverClassName(this.driverClassName);
        dao.setUrl(this.url);
        dao.setUser(this.user);
        dao.setPassword(this.password);
        return dao;
    }
}
