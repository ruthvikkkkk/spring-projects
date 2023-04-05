package com.myexamples.reactivetwo.reactivetwo.controller;

import com.myexamples.reactivetwo.reactivetwo.dto.DirectorDto;
import com.myexamples.reactivetwo.reactivetwo.dto.MovieDto;
import com.myexamples.reactivetwo.reactivetwo.entity.Director;
import com.myexamples.reactivetwo.reactivetwo.repository.DirectorRepository;
import com.myexamples.reactivetwo.reactivetwo.services.DirectorService;
import com.myexamples.reactivetwo.reactivetwo.services.MovieService;
import com.myexamples.reactivetwo.reactivetwo.utils.DataUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    DirectorService directorService;

    @Autowired
    DirectorRepository directorRepository;

    @GetMapping("/getAll")
    public ResponseEntity<Flux<MovieDto>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies()
                                                .map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @GetMapping("/getOneById/{id}")
    public ResponseEntity<Mono<MovieDto>> getById(@PathVariable Integer id){
        return new ResponseEntity<>(movieService.getMovieById(id)
                                                .map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Mono<MovieDto>> addMovie(@RequestBody MovieDto movieDto){
//        return new ResponseEntity<>(Mono.just(directorService.checkIfDirectorExists(movieDto.getDirectorname())
//                        .flatMap(aBoolean -> {
//                            if(!aBoolean){
//                                DirectorDto directorDto = new DirectorDto();
//                                directorDto.setName(movieDto.getDirectorname());
//                                directorService.addDirector(directorDto);
//                            }
//                            movieService.addMovie(movieDto);
//                            return Mono.just(aBoolean);
//                        })).hasElement(), HttpStatus.OK);

//        return new ResponseEntity<>(directorService.checkIfDirectorExists(movieDto.getDirectorname()).flatMap(bool -> {
//            if(!bool){
//                DirectorDto directorDto = new DirectorDto();
//                directorDto.setName(movieDto.getDirectorname());
//                directorService.addDirector(directorDto);
//            }
//            movieService.addMovie(movieDto);
//            return Mono.just(Boolean.TRUE);
//        }).hasElement(), HttpStatus.OK);

        return new ResponseEntity<>(movieService.addMovie(movieDto).map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @GetMapping("/getAllByName/{name}")
    public ResponseEntity<Flux<MovieDto>> getMoviesByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieByName(name)
                                                .map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @GetMapping("/getDirector/{name}")
    public ResponseEntity<Flux<String>> getDirectorsByMovieName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirectorNameByMovieName(name), HttpStatus.OK);
    }

    @GetMapping("/getMoviesByDirector/{name}")
    public ResponseEntity<Flux<MovieDto>> getMoviesByDirector(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name).map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @PutMapping("/updateDirector/{name}/{director}")
    public ResponseEntity<Flux<MovieDto>> updateDirectorOfMovies(@PathVariable("name") String name, @PathVariable("director") String directorName){
        return new ResponseEntity<>(movieService.updateDirectorByMovieName(name, directorName).map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Mono<Void>> deleteMovie(@PathVariable String name){
        return new ResponseEntity<>(movieService.deleteMovieByName(name), HttpStatus.OK);
    }
}
