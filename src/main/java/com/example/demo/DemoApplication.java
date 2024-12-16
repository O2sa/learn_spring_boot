package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    // SpringApplication app = new SpringApplication(DemoApplication.class);
    // System.setProperty("spring.profiles.active", "dev");

    var ctx = SpringApplication.run(DemoApplication.class, args);

    // MyFirstService mFirstService = ctx.getBean(MyFirstService.class);
    // System.out.println(mFirstService.tellAStory());
    // System.out.println(mFirstService.getCutomProp());
    // System.out.println(mFirstService.getMyCustomProp());

  }

}