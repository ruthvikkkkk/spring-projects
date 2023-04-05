package com.example.reactivecommand.command.impl;

import com.example.reactivecommand.command.MongoCommand;
import com.example.reactivecommand.entity.Director;
import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.MovieRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateDirectorAgeCommandImpl implements MongoCommand {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Mono<UpdateResult> execute(Object obj) {
        Director director = (Director) obj;
        return movieRepository.updateAge(director.getName(), director.getAge());
    }
}
