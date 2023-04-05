package com.example.reactivecommand.command;

import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.MovieRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.util.function.Function;

@Component
public interface MongoRemote {
    <T> Mono<T> execute(MongoCommand mongoCommand, java.lang.Object movie);
}