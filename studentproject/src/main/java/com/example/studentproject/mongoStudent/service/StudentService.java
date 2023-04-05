package com.example.studentproject.mongoStudent.service;

import com.example.studentproject.mongoStudent.entity.Student;

public interface StudentService {
    Student addOrUpdate(Student t);
    Boolean deleteById(String id);
    Student get(String id);
}
