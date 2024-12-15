package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {

    @Autowired
    private  MyFirstClass myFirstClass;

    @Value("${my.prop}")
    private String cutomProp;

    public String getMyCustomProp() {
        return myCustomProp;
    }



    @Value("${my.custom.prop}")
    private String myCustomProp;
 

    public String getCutomProp() {
        return cutomProp;
    }


    public String tellAStory() {
        return "hello from dependce >> " + myFirstClass.sayHello();
    }
}
