package com.example.demo.beans;

import org.springframework.stereotype.Service;

public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
       return "helllo from special class >>" + myVar;
    }

}