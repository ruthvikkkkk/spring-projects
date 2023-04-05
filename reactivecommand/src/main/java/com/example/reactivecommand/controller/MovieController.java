package com.example.reactivecommand.controller;

import com.example.reactivecommand.command.MongoRemote;
import com.example.reactivecommand.command.impl.*;
import com.example.reactivecommand.entity.Director;
import com.example.reactivecommand.entity.Movie;
import com.example.reactivecommand.repository.MovieRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MongoRemote mongoRemote;

    @Autowired
    SaveMovieCommandImpl saveMovieCommandImpl;

    @Autowired
    GetAllMovieCommandImpl getAllMovieCommandImpl;

    @Autowired
    GetOneMovieCommandImpl getOneMovieCommandImpl;

    @Autowired
    DeleteMovieCommandImpl deleteMovieCommand;

    @Autowired
    UpdateDirectorAgeCommandImpl updateDirectorAgeCommand;

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/add")
    public ResponseEntity<Mono<Movie>> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(mongoRemote.execute(saveMovieCommandImpl, movie), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Mono<List<Movie>>> getAll(){
        return new ResponseEntity<>(mongoRemote.execute(getAllMovieCommandImpl, null), HttpStatus.OK);
    }

    @GetMapping("/getOne/{movie}")
    public ResponseEntity<Mono<String>> getOne(@PathVariable String movie){
        return new ResponseEntity<>(mongoRemote.execute(getOneMovieCommandImpl, movie).map(Objects::toString), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{movie}")
    public ResponseEntity<Mono<Movie>> deleteOne(@PathVariable("movie") String name){
        return new ResponseEntity<>(mongoRemote.execute(deleteMovieCommand, name), HttpStatus.OK);
    }

    @PatchMapping("/updateAge")
    public ResponseEntity<Mono<UpdateResult>> updateAll(@RequestBody Director director){
        return new ResponseEntity<>(mongoRemote.execute(updateDirectorAgeCommand, director), HttpStatus.OK);
    }
}
