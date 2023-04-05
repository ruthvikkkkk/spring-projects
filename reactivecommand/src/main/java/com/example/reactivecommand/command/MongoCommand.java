package com.example.reactivecommand.command;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface MongoCommand {
    <T> Mono<T> execute(Object obj);
}
