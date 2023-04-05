package com.example.student.mongoStudent.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = Course.COLLECTION_NAME)
public class Course {
    public static final String COLLECTION_NAME="mongoCourse";

    @Id
    private String courseId;
    private String courseName;
    private Double coursefee;
    private String courseProgress;
    private List<Instructor> instructor;
}
