package com.example.onedemo.services.implementations;

import com.example.onedemo.services.ServiceOneInterface;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("ServiceTwo")
public class ServiceTwoImpl implements ServiceOneInterface {

    ServiceTwoImpl(){
        System.out.println("Implementing Service Two");
    }

    @Override
    public String printService() {
        return "Print Service of serviceTwo";
    }

    @PostConstruct
    public void post(){
        System.out.println("Post Construct of Service Two");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pre Destroy of Service Two");
    }
}
