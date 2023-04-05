package com.example.student.postgresStudent.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@ToString
@Table
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "student_courses", joinColumns = {
            @JoinColumn(name = "student_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "course_id")
    })
    private List<Course> coursesEnrolled;
}