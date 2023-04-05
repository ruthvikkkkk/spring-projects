package com.example.student.DTO;

import com.example.student.entity.Instructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@ToString
public class CourseDTO {
    @Id
    private String courseId;
    private String courseName;
    private Double coursefee;
    private String courseProgress;
    private List<Instructor> instructor;
}
