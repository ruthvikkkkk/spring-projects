package com.myexamples.reactivetwo.reactivetwo.services.impl;

import com.myexamples.reactivetwo.reactivetwo.dto.DirectorDto;
import com.myexamples.reactivetwo.reactivetwo.dto.MovieDto;
import com.myexamples.reactivetwo.reactivetwo.entity.Movie;
import com.myexamples.reactivetwo.reactivetwo.repository.MovieRepository;
import com.myexamples.reactivetwo.reactivetwo.services.DirectorService;
import com.myexamples.reactivetwo.reactivetwo.services.MovieService;
import com.myexamples.reactivetwo.reactivetwo.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorService directorService;

    @Override
    public Mono<Movie> addMovie(MovieDto movieDto) {
        return movieRepository.save(DataUtils.dtoToEntity(movieDto));
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Mono<Movie> getMovieById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getMovieByName(String name) {
        return movieRepository.findMoviesByName(name);
    }

    @Override
    public Flux<String> getDirectorNameByMovieName(String name) {

        return movieRepository.findDirectornameByName(name);
    }

    @Override
    public Flux<Movie> getMoviesByDirectorName(String name) {

        return movieRepository.findMoviesByDirectornameContainingIgnoreCase(name);
    }

    @Override
    public Flux<Movie> updateDirectorByMovieName(String name, String directorName) {
        return movieRepository.findMoviesByName(name)
                                .map(movie -> {
                                    movie.setDirectorname(directorName);
                                    return movie;
                                })
                                .flatMap(movieRepository::save);
    }

    @Override
    public Mono<Void> deleteMovieByName(String name) {
        return movieRepository.deleteByName(name);
    }
}
