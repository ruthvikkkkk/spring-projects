package com.example.reactivecommand.repository.impl;

import com.example.reactivecommand.entity.Director;
import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.CustomMovieRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import reactor.core.publisher.Mono;


public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Autowired
    public CustomMovieRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
        this.reactiveMongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Movie> findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return reactiveMongoTemplate.findOne(query, Movie.class);
    }

    @Override
    public Mono<Movie> deleteByName(String name) {
        Query query = new Query(
                Criteria.where("name").is(name)
        );
        return reactiveMongoTemplate.findAndRemove(query, Movie.class);
    }

    @Override
    public Mono<UpdateResult> updateAge(String name, Integer age) {
        Director director = new Director();
        director.setAge(age);
        director.setName(name);
        Query query = new Query(
                Criteria.where("director.name").is(name)
        );
        Update update = new Update().set("director.age", age);
        return reactiveMongoTemplate.updateMulti(query, update, Movie.class);
    }
}
