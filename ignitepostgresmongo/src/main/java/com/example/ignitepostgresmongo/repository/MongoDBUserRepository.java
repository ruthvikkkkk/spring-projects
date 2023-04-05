package com.example.ignitepostgresmongo.repository;

import com.example.ignitepostgresmongo.entity.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBUserRepository extends MongoRepository<MongoUser, Long> {
}
