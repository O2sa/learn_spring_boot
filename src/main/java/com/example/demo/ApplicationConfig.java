package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    @Primary
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First bean");
    }
    @Bean("bean2")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("second bean");
    }
}