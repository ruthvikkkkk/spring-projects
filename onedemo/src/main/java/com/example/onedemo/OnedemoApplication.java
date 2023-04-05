package com.example.onedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnedemoApplication {

	public static void main(String[] args) {
		System.out.println("Starting...");
		SpringApplication.run(OnedemoApplication.class, args);
		System.out.println("End...");
	}

}
