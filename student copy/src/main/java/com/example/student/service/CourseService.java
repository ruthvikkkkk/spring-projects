package com.example.student.service;

import com.example.student.DTO.CourseDTO;
import com.example.student.entity.Course;

import java.util.List;

public interface CourseService {
    Course addOrUpdate(CourseDTO courseDTO);
    Course get(String id);
    Boolean deleteById(String id);
    List<Course> findAll();
}
