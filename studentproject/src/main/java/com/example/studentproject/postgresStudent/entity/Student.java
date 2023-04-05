package com.example.studentproject.postgresStudent.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class Student {

    public static final String COLLECTION_NAME="mongoStudent";

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "student_courses", joinColumns = {
            @JoinColumn(name = "student_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "course_id")
    })
    private List<Course> coursesEnrolled;
}
