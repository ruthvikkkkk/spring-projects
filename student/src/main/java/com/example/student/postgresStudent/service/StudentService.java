package com.example.student.postgresStudent.service;

import com.example.student.postgresStudent.entity.Student;
import org.springframework.stereotype.Service;

public interface StudentService {
    Student addOrUpdate(Student student);
    Boolean deleteById(Long id);
    Student get(Long id);
}
