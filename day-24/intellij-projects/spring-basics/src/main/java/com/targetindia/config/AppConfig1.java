package com.targetindia.config;

import com.targetindia.dao.HibernateProductDao;
import com.targetindia.dao.JdbcProductDao;
import com.targetindia.dao.MybatisProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
public class AppConfig1 {
    public AppConfig1() {
        log.trace("AppConfig1 constructor called");
    }

    // spring calls the methods in this class to collect beans, only if the method
    // is annotated with @Bean

    @Bean
    public JdbcProductDao dao1(){
        log.trace("AppConfig1.dao1() called");
        JdbcProductDao dao = new JdbcProductDao();

        log.trace("returning an object of JdbcProductDao to the spring container");
        return dao;
    }

    @Bean
    public HibernateProductDao dao2(){
        log.trace("AppConfig1.dao2() called");
        HibernateProductDao dao = new HibernateProductDao();

        log.trace("returning an object of HibernateProductDao to the spring container");
        return dao;
    }


    @Bean
    public MybatisProductDao dao3(){
        log.trace("AppConfig1.dao3() called");
        MybatisProductDao dao = new MybatisProductDao();

        log.trace("returning an object of MybatisProductDao to the spring container");
        return dao;
    }
}
