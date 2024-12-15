package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyFirstController {

    // Get all users

    @PostMapping("/post")
    public String postMethodName(@RequestBody String entity) {

        return "request is accetpeted >> " + entity;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestBody String entity) {

        return "hello >> " + entity;
    }
    @PostMapping("/post-user")
    public String postUser(@RequestBody MyFirstEntity entity) {

        System.out.println(entity);
        return "request is accetpeted >> " + entity.toString();
    }

    @PostMapping("/post-record")
    public String postRecord(@RequestBody MyFirstRecord entity) {

        return "request is accetpeted >> " + entity;
    }

}
