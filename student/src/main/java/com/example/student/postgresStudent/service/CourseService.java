package com.example.student.postgresStudent.service;

import com.example.student.postgresStudent.entity.Course;
import org.springframework.stereotype.Service;


public interface CourseService {
    Course addOrUpdate(Course course);
    Boolean deleteById(String id);
    Course get(String id);
}
