package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(DemoApplication.class);
    System.setProperty("spring.profiles.active", "dev");

    var ctx = SpringApplication.run(DemoApplication.class, args);

    MyFirstService mFirstService = ctx.getBean(MyFirstService.class);
    System.out.println(mFirstService.tellAStory());
    System.out.println(mFirstService.getCutomProp());
    System.out.println(mFirstService.getMyCustomProp());

  }

}