package com.example.studentproject.postgresStudent.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@ToString
public class Instructor {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date dateOfBirth;
    private Date dateOfJoining;

    @ManyToOne
    @JoinColumn(name = "instructor_course_id", referencedColumnName = "id")
    private String courseId;
    private Double salary;
}
