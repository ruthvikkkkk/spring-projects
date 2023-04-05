package com.example.contestservice.repository;

import com.example.contestservice.entity.Contest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContestRepo extends MongoRepository<Contest, String> {

    public List<Contest> findBycontentCategory(String contest);

    Iterable<Contest> findAllByQuizMasterId();
}
