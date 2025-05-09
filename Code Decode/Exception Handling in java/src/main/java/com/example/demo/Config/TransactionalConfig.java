package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class TransactionalConfig {

//    @Bean
//    public DataSource setDataSourceCustom(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUsername("sa");
//        dataSource.setUsername("1234");
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
}
