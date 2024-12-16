package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean
    @Primary
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("Dev bean");
    }
    @Bean("bean2")
    @Profile("test")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("second bean");
    }
}


