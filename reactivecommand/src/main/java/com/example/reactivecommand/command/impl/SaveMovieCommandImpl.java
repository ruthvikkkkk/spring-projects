package com.example.reactivecommand.command.impl;

import com.example.reactivecommand.command.MongoCommand;
import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SaveMovieCommandImpl implements MongoCommand {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Mono<Movie> execute(Object movie) {
        return movieRepository.save((Movie) movie);
    }
}
