package com.example.reactivecommand.command.impl;

import com.example.reactivecommand.command.MongoCommand;
import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteMovieCommandImpl implements MongoCommand {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Mono<Movie> execute(Object name) {
        return movieRepository.deleteByName((String) name);
    }
}
