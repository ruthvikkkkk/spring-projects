package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    //List<Student> findStudentIdStudentNameByCourseInCoursesEnrolled(String id);
    //List<Student> findStudentNameByCourseProgress(String courseProgress);
}
