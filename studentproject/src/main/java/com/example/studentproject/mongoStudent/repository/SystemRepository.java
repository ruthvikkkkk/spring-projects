package com.example.studentproject.mongoStudent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository<T, String> extends MongoRepository<T, String> {
}
