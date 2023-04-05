package com.example.reactivecommand.repository;

import com.example.reactivecommand.entity.Movie;
import com.mongodb.client.result.UpdateResult;
import reactor.core.publisher.Mono;

public interface CustomMovieRepository {
    Mono<Movie> findByName(String name);
    Mono<Movie> deleteByName(String name);
    Mono<UpdateResult> updateAge(String name, Integer age);
}
