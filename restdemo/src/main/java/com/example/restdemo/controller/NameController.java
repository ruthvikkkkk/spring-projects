package com.example.restdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class NameController {

    NameController(){
        System.out.println("Creating Name Object!");
    }
    @GetMapping("/name")
    public String name(){
        return "ruthvik";
    }
}
