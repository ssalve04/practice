package com.hibernate.hibernatedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class DBConfig {

//    @Value("${}")
//    private String driverClass;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource getDataSource(){
        DataSource dataSource= new DriverManagerDataSource(url,username,password);
        return  dataSource;
    }

    public Properties hibernateProperties(){
        Properties properties= new Properties();
        properties.putIfAbsent("",true);
        return properties;
    }
}
