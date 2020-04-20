package com.example.weatherking.database;

import com.example.weatherking.BaseBean;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration extends BaseBean {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource(HikariConfig hikariConfig) {
        DataSource dataSource = new HikariDataSource(hikariConfig);
        System.out.println(dataSource.toString());
        return dataSource;
    }
}
