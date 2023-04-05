package com.example.studentproject.mongoStudent.repository;

import com.example.studentproject.mongoStudent.entity.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
}
