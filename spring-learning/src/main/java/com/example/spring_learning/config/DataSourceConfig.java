package com.example.spring_learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public String devDataSource() {
        return "Connected to DEV Database";
    }

    @Bean
    @Profile("prod")
    public String prodDataSource() {
        return "Connected to PROD Database";
    }
}
