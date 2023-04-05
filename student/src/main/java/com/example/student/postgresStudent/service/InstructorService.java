package com.example.student.postgresStudent.service;


import com.example.student.postgresStudent.entity.Instructor;
import org.springframework.stereotype.Service;

public interface InstructorService {
    Instructor addOrUpdate(Instructor instructor);
    Boolean deleteById(String id);
    Instructor get(String id);
}
