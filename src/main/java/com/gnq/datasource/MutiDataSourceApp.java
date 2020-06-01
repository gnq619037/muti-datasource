package com.gnq.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MutiDataSourceApp {
    public static void main(String[] args) {
        SpringApplication.run(MutiDataSourceApp.class, args);
    }
}
