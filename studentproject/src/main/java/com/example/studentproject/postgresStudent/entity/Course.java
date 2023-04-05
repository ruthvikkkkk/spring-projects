package com.example.studentproject.postgresStudent.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;

@Data
@ToString
public class Course {

    @Id
    private String id;
    private String courseName;
    private Double coursefee;
    private String courseProgress;

}