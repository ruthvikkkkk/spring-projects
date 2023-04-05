package com.example.contestservice.repository;

import com.example.contestservice.entity.Ranking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface RankingRepo extends MongoRepository<Ranking,String> {
}
