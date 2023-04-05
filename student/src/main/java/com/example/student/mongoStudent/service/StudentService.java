package com.example.student.mongoStudent.service;

import com.example.student.mongoStudent.DTO.StudentDTO;
import com.example.student.mongoStudent.entity.Course;
import com.example.student.mongoStudent.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Student get(String id);
    Student addOrUpdate(StudentDTO studentDTO);
    Boolean deleteById(String id);
    List<Student> findAll();
    Map<String, String> findByCourse(String id);
    Map<String, String> findByCourseStatus(String status);
    Course addCourse(String id, Course course);
}
