package com.myexamples.reactivetwo.reactivetwo.services;

import com.myexamples.reactivetwo.reactivetwo.dto.DirectorDto;
import com.myexamples.reactivetwo.reactivetwo.entity.Director;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DirectorService {
    Mono<Director> addDirector(DirectorDto directorDto);
    Flux<Director> getAllDirectors();
    Mono<Integer> getDirectorAgeByName(String name);
    Flux<Director> getDirectorsByAge(Integer age);
    Mono<Director> checkIfDirectorExists(String name);
    Mono<Integer> updateAgeByName(String name, Integer age);
    Mono<Void> deleteByName(String name);
}
