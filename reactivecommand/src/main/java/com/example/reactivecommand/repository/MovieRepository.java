package com.example.reactivecommand.repository;

import com.example.reactivecommand.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String>, CustomMovieRepository {
}