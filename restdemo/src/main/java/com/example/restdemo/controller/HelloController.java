package com.example.restdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    HelloController(){
        System.out.println("Creating Hello Object!");
    }

    @GetMapping("/hello")
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(){
        return "Hello There!";
    }

    public String name(){
        return "ruthvik";
    }
}
