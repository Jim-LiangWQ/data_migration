package com.pccw.data.migration.configs;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:15
 **/

@Configuration
@Slf4j
public class DataSourceConfig {

    @Autowired
    private ArsProperties arsProperties;

    @Autowired
    private AmsProperties amsProperties;

    @Autowired
    private PasProperties pasProperties;

    @Primary
    @Bean(name = "arsDataSource")
    public DataSource arsDataSource(){
        log.info("ARS DataSource初始化----111111");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(arsProperties.getUrl());
        dataSource.setUsername(arsProperties.getUsername());
        dataSource.setPassword(arsProperties.getPassword());
        dataSource.setDriverClassName(arsProperties.getDriverClassName());
        return dataSource;
    }


    @Bean(name = "pasDataSource")
    public DataSource pasDataSource(){
        log.info("PAS DataSource初始化----222222222");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(pasProperties.getUrl());
        dataSource.setUsername(pasProperties.getUsername());
        dataSource.setPassword(pasProperties.getPassword());
        dataSource.setDriverClassName(pasProperties.getDriverClassName());
        return dataSource;
    }

    @Bean(name = "amsDataSource")
    public DataSource amsDataSource(){
        log.info("AMS DataSource初始化----33333");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(amsProperties.getUrl());
        dataSource.setUsername(amsProperties.getUsername());
        dataSource.setPassword(amsProperties.getPassword());
        dataSource.setDriverClassName(amsProperties.getDriverClassName());
        return dataSource;
    }
}
