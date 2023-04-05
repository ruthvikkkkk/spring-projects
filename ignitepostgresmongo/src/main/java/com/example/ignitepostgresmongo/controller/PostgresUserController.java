package com.example.ignitepostgresmongo.controller;

import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.IgniteUser;
import com.example.ignitepostgresmongo.entity.PostgresUser;
import com.example.ignitepostgresmongo.service.IgniteUserService;
import com.example.ignitepostgresmongo.service.MongoUserService;
import com.example.ignitepostgresmongo.service.PostgresUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgresUser")
public class PostgresUserController {

    @Autowired
    PostgresUserService postgresUserService;

    @Autowired
    IgniteUserService igniteUserService;

    @Autowired
    MongoUserService mongoUserService;

    @PostMapping("/add")
    public ResponseEntity<PostgresUser> addUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(postgresUserService.addUser(userDto), HttpStatus.OK);
    }

//    @GetMapping("/getFromCache/{id}")
//    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
//        return new ResponseEntity<>(igniteUserService.getUser(id), HttpStatus.OK);
//    }

    @GetMapping("/getAllFromCache")
    public ResponseEntity<List<UserDto>> getAll(){
        return new ResponseEntity<>(igniteUserService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/addManyUsers/{count}")
    public ResponseEntity<String> addMany(@PathVariable Long count){
        return new ResponseEntity<>(postgresUserService.addManyUsers(count), HttpStatus.OK);
    }

    @GetMapping("/getIgniteCount")
    public ResponseEntity<Integer> getIgniteLength(){
        return new ResponseEntity<>(igniteUserService.getNumberOfRecord(), HttpStatus.OK);
    }

    @GetMapping("/getMongoCount")
    public ResponseEntity<Integer> getMongoLength(){
        return new ResponseEntity<>(mongoUserService.getNumberOfDocuments(), HttpStatus.OK);
    }

    @GetMapping("/getPostgresCount")
    public ResponseEntity<Integer> getPostgresLength(){
        return new ResponseEntity<>(postgresUserService.getNumberOfRecords(), HttpStatus.OK);
    }

    @GetMapping("/addManyIgnite/{count}")
    public ResponseEntity<String> addMapyIgniteUsers(Long count){
        return new ResponseEntity<>(igniteUserService.addManyIgniteUsers(count), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllFromCache")
    public void deleteAll(){
        igniteUserService.deleteAllFromCache();
    }
}
