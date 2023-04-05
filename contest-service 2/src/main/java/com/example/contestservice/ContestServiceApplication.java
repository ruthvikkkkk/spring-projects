package com.example.contestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContestServiceApplication.class, args);
	}

}
