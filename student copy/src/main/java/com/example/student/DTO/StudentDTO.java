package com.example.student.DTO;

import com.example.student.entity.Course;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class StudentDTO {

    @Id
    private String studentId;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private List<Course> coursesEnrolled;
}
