package com.example.onedemo.services.implementations;

import com.example.onedemo.services.ServiceOneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("ServiceOne")
@Primary
public class ServiceOneImpl implements ServiceOneInterface {

    ServiceOneImpl(){
        System.out.println("Implementing ServiceOneImpl");
    }

    @PostConstruct
    public void post(){
        System.out.println("Post Construct of ServiceOneImpl");
    }

    @Override
    public String printService() {
        return "Printing : Service One";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pre Destroy of Service One");
    }

}
