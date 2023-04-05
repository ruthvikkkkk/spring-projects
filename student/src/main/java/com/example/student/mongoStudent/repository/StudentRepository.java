package com.example.student.mongoStudent.repository;

import com.example.student.mongoStudent.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    //List<Student> findStudentIdStudentNameByCourseInCoursesEnrolled(String id);
    //List<Student> findStudentNameByCourseProgress(String courseProgress);
}
