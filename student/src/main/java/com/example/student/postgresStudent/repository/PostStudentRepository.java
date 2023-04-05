package com.example.student.postgresStudent.repository;

import com.example.student.postgresStudent.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface PostStudentRepository extends CrudRepository<Student, Long> {
}
