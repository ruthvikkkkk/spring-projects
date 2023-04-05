package com.example.student.postgresStudent.repository;

import com.example.student.postgresStudent.entity.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface PostInstructorRepository extends CrudRepository<Instructor, String> {
}
