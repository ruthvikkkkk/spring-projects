package com.example.reactivecommand.command.impl;

import com.example.reactivecommand.command.MongoCommand;
import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllMovieCommandImpl implements MongoCommand {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Mono<List<Movie>> execute(Object obj) {
        return movieRepository.findAll().collect(Collectors.toList());
    }
}
