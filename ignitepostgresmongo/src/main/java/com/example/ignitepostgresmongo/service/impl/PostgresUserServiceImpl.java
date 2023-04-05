package com.example.ignitepostgresmongo.service.impl;

import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.IgniteUser;
import com.example.ignitepostgresmongo.entity.MongoUser;
import com.example.ignitepostgresmongo.entity.PostgresUser;
import com.example.ignitepostgresmongo.repository.PostgresUserRepository;
import com.example.ignitepostgresmongo.service.IgniteUserService;
import com.example.ignitepostgresmongo.service.MongoUserService;
import com.example.ignitepostgresmongo.service.PostgresUserService;
import com.example.ignitepostgresmongo.utils.Converter;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class PostgresUserServiceImpl implements PostgresUserService {

    @Autowired
    PostgresUserRepository userRepository;

    @Autowired
    MongoUserService mongoUserService;



    @Override
    public PostgresUser addUser(UserDto user) {
        PostgresUser postgresUser =  userRepository.save(Converter.toPostgresUserEntity(user));

        mongoUserService.addUser(Converter.toMongoUser(postgresUser));
        //igniteUserService.addUser(Converter.toIgniteUser(postgresUser));

        return postgresUser;
    }

    @Override
    public String addManyUsers(Long count) {
        List<PostgresUser> userList = new ArrayList<>();
        long start = System.currentTimeMillis();
        Random random = new Random();

        if(count >= 100000) {
            for (int i = 0; i < count; i++) {
                UserDto userDto = new UserDto();
                userDto.setName("employee - " + Math.abs(random.nextLong()));
                userDto.setAge((20 + (random.nextInt(70))) % 70);

                userList.add(Converter.toPostgresUserEntity(userDto));

                if(userList.size() == 100000){
                    addAll(userList);
                    userList = new ArrayList<>();
                }
            }
            addManyUsers(count % 100000);
        }else{
            for (int i = 0; i < count; i++) {
                UserDto userDto = new UserDto();
                userDto.setName("employee" + random.nextLong());
                userDto.setAge(random.nextInt(80));

                userList.add(Converter.toPostgresUserEntity(userDto));
            }
            addAll(userList);
        }
        long end = System.currentTimeMillis();
        return ((end - start)/1000) + "s --- " + ((end - start)/60000) + "min";
    }

    public void addAll(List<PostgresUser> userList){
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                userRepository.saveAll(userList);
                System.out.println("INSERTED!");

//                Executors.newCachedThreadPool().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("INSERTING INTO MONGO!");
//                        List<MongoUser> mongoUserList = userList.stream()
//                                .map(Converter::toMongoUser)
//                                .collect(Collectors.toList());
//
//                        mongoUserService.addAll(mongoUserList);
//                    }
//                });
            }
        });

//        Executors.newCachedThreadPool().execute(new Runnable() {
//            @Override
//            public void run() {
//                List<UserDto> userDtoList = userList.stream()
//                        .map(Converter::toUserDto)
//                        .collect(Collectors.toList());
//
//                igniteUserService.addAll(userDtoList);
//            }
//        });
    }

    @Override
    public Integer getNumberOfRecords() {
        return userRepository.findAll().size();
    }

}
