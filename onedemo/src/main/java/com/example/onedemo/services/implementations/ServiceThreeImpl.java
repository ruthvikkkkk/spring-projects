package com.example.onedemo.services.implementations;

import com.example.onedemo.services.ServiceOneInterface;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("ServiceThree")
public class ServiceThreeImpl implements ServiceOneInterface {

    ServiceThreeImpl(){
        System.out.println("Implementing Service Three");
    }

    @Override
    public String printService() {
        return "Printing : Service Three";
    }

    @PostConstruct
    public void post(){
        System.out.println("Post Construct of Service Three");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pre Destroy of Service Three");
    }
}
