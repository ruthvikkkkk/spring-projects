package com.example.student.postgresStudent.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Table
@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private Date dateOfJoining;

    @OneToOne(targetEntity = Course.class)
    @JoinColumn(name = "instructor_course_id", referencedColumnName = "id")
    @JoinTable(name = "instructor_courses", joinColumns = {
            @JoinColumn(name = "instructor_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "course_id")
    })
    private String courseId;
    private Double salary;
}