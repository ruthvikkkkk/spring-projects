package com.example.studentproject.mongoStudent.repository;

import com.example.studentproject.mongoStudent.entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
