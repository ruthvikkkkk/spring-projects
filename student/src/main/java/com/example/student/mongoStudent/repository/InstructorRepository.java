package com.example.student.mongoStudent.repository;

import com.example.student.mongoStudent.entity.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String > {
}
