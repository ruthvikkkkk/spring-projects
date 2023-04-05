package com.example.student.postgresStudent.repository;

import com.example.student.postgresStudent.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface PostCourseRepository extends CrudRepository<Course, String> {
}
