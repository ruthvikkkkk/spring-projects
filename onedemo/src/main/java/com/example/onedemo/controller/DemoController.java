package com.example.onedemo.controller;

import com.example.onedemo.services.ServiceOneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
public class DemoController {

    DemoController(){
        System.out.println("Creating DemoController bean");
    }

    @PostConstruct
    public void post(){
        System.out.println("Post Construct of DemoController");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pre Destroy of DemoController");
    }

    @Qualifier("ServiceOne")
    @Autowired
    ServiceOneInterface serviceOne;

    @Qualifier("ServiceTwo")
    @Autowired
    ServiceOneInterface serviceTwo;

    @Autowired
    ServiceOneInterface serviceThree;

    @GetMapping("/service1")
    public String printServiceOne(){
        return serviceOne.printService();
    }

    @GetMapping("/service2")
    public String printServiceTwo(){
        return serviceTwo.printService();
    }

    @GetMapping("/service3")
    public String printServiceThree(){
        return serviceThree.printService();
    }
}
