package com.example.student.mongoStudent.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@ToString
@Document(collection = Instructor.COLLECTION_NAME)
public class Instructor {

    public static final String COLLECTION_NAME="mongoInstructor";

    @Id
    private String instructorId;
    private String name;
    private String phoneNumber;
    private Date dateOfJoining;
    private Double salary;
}
