package com.example.studentproject.mongoStudent.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Document(Student.COLLECTION_NAME)
public class Student {

    public static final String COLLECTION_NAME="mongoStudent";

    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private List<Course> coursesEnrolled;
}