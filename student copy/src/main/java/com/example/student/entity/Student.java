package com.example.student.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@ToString
@Document(Student.COLLECTION_NAME)
public class Student {

    public static final String COLLECTION_NAME="mongoStudent";

    @Id
    private String studentId;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private List<Course> coursesEnrolled;
}