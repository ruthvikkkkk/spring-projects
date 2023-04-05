package com.myexamples.reactivetwo.reactivetwo.controller;

import com.myexamples.reactivetwo.reactivetwo.dto.DirectorDto;
import com.myexamples.reactivetwo.reactivetwo.entity.Director;
import com.myexamples.reactivetwo.reactivetwo.services.DirectorService;
import com.myexamples.reactivetwo.reactivetwo.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @GetMapping("/getAll")
    public ResponseEntity<Flux<DirectorDto>> getAllDirectors(){
        return new ResponseEntity<>(directorService.getAllDirectors().map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @GetMapping("/getAge/{name}")
    public ResponseEntity<Mono<Integer>> getAgeByName(@PathVariable String name){
        return new ResponseEntity<>(directorService.getDirectorAgeByName(name), HttpStatus.OK);
    }

    @GetMapping("/getDirectorsByAge/{age}")
    public ResponseEntity<Flux<DirectorDto>> getDirectorsByAge(@PathVariable Integer age){
        return new ResponseEntity<>(directorService.getDirectorsByAge(age).map(DataUtils::entityToDto), HttpStatus.OK);
    }

    @PostMapping("/addDirector")
    public ResponseEntity<Mono<DirectorDto>> addDirector(@RequestBody DirectorDto directorDto){
        return new ResponseEntity<>(directorService.addDirector(directorDto).map(DataUtils::entityToDto), HttpStatus.CREATED);
    }

    @GetMapping("/getDirectorByName/{name}")
    public ResponseEntity<Mono<Director>> getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(directorService.checkIfDirectorExists(name), HttpStatus.OK);
    }

    @PutMapping("/updateAge/{name}/{age}")
    public ResponseEntity<Mono<Integer>> updateAgeByName(@PathVariable("name") String name, @PathVariable("age") Integer age){
        return new ResponseEntity<>(directorService.updateAgeByName(name, age), HttpStatus.OK);
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Mono<Void>> deleteByName(@PathVariable("name") String name){
        return new ResponseEntity<>(directorService.deleteByName(name), HttpStatus.OK);
    }
}
