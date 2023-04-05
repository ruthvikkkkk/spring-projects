package com.example.student.mongoStudent.service;

import com.example.student.mongoStudent.DTO.CourseDTO;
import com.example.student.mongoStudent.entity.Course;

import java.util.List;

public interface CourseService {
    Course addOrUpdate(CourseDTO courseDTO);
    Course get(String id);
    Boolean deleteById(String id);
    List<Course> findAll();
}
