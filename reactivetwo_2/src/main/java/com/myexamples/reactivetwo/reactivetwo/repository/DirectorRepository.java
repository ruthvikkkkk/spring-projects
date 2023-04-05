package com.myexamples.reactivetwo.reactivetwo.repository;

import com.myexamples.reactivetwo.reactivetwo.entity.Director;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DirectorRepository extends ReactiveCrudRepository<Director, Integer > {

    @Query("select directors.age from directors where directors.name = :name")
    Mono<Integer> findDirectorAgeByName(@Param("name") String name);

    Flux<Director> findDirectorsByAge(Integer age);

    Mono<Director> findByName(String name);

    @Modifying
    @Query("update directors set age = :age where name = :name")
    Mono<Integer> updateAgeByName(@Param("name") String name, @Param("age") Integer age);

    Mono<Void> deleteByName(String name);
}
