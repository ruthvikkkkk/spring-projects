package com.example.reactivecommand.command.impl;

import com.example.reactivecommand.command.MongoCommand;
import com.example.reactivecommand.command.MongoRemote;
import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MongoRemoteImpl implements MongoRemote {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Mono<Object> execute(MongoCommand mongoCommand, Object obj) {
        return mongoCommand.execute(obj);
    }
}
