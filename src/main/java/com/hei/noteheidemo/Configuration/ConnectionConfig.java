package com.hei.noteheidemo.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Component
public class ConnectionConfig {
    @Value("${spring.datasource.url}")
    private String url ;
    @Value("${spring.datasource.username}")
    private String username ;
    @Value("${spring.datasource.password}")
    private String password ;

    @Bean
    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection(
                this.url ,this.username ,this.password
        );
    }

}
