package com.myexamples.reactivetwo.reactivetwo.repository;

import com.myexamples.reactivetwo.reactivetwo.entity.Movie;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveCrudRepository<Movie, Integer> {
    Flux<Movie> findMoviesByName(String name);

    @Query("select movies.directorname from movies where movies.name = :name")
    Flux<String> findDirectornameByName(@Param("name") String name);

    Flux<Movie> findMoviesByDirectornameContainingIgnoreCase(String director_name);

    Mono<Void> deleteByName(String name);
}
