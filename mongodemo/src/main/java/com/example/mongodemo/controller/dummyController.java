package com.example.mongodemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dummy")
public class dummyController {

    @GetMapping("/controller")
    public ResponseEntity<String> dummyControl(){
        return new ResponseEntity<String>("Dummy Output!", HttpStatus.BAD_REQUEST);
    }
}
