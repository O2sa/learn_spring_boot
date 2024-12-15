package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    private  MyFirstClass myFirstClass;

    public String tellAStory() {
        return "hello from dependce >> " + myFirstClass.sayHello();
    }
}
