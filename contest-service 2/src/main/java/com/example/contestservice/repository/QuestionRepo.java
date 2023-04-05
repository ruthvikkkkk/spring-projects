package com.example.contestservice.repository;

import com.example.contestservice.entity.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends MongoRepository<Questions, String> {
}
