package com.example.studentproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.studentproject.mongoStudent")
public class StudentprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentprojectApplication.class, args);
	}

}
