package com.example.studentproject.mongoStudent.DTO;

import com.example.studentproject.mongoStudent.entity.Course;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class StudentDTO {

    private String studentId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private List<Course> coursesEnrolled;
}
