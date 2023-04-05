package com.myexamples.reactivetwo.reactivetwo.services;

import com.myexamples.reactivetwo.reactivetwo.dto.MovieDto;
import com.myexamples.reactivetwo.reactivetwo.entity.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Mono<Movie> addMovie(MovieDto movieDto);
    Flux<Movie> getAllMovies();
    Mono<Movie> getMovieById(Integer id);
    Flux<Movie> getMovieByName(String name);
    Flux<String> getDirectorNameByMovieName(String name);
    Flux<Movie> getMoviesByDirectorName(String name);
    Flux<Movie> updateDirectorByMovieName(String name, String directorName);
    Mono<Void> deleteMovieByName(String name);
}
