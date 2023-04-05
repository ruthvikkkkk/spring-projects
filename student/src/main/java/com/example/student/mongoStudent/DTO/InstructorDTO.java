package com.example.student.mongoStudent.DTO;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Data
@ToString
public class InstructorDTO {

    @Id
    private String instructorId;
    private String name;
    private String phoneNumber;
    private Date dateOfJoining;
    //private String courseId;
    //private Double salary;
}
