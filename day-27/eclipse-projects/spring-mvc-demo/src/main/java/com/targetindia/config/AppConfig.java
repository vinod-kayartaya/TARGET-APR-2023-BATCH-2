package com.targetindia.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@Configuration
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = {"com.targetindia.dao", "com.targetindia.controllers"})
public class AppConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		log.trace("creating spring container...");

		// create a new spring container
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		
		log.trace("creating DispatcherServlet...");
		
		Dynamic ds = servletContext.addServlet("ds", new DispatcherServlet(ctx));
		ds.addMapping("/"); // any request from the client will reach this servlet
		ds.setLoadOnStartup(1); // load this servlet in the beginning
	}

	
	
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
