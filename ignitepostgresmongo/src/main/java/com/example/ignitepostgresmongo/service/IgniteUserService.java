package com.example.ignitepostgresmongo.service;

import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.IgniteUser;

import java.util.List;

public interface IgniteUserService {

    //IgniteUser addUser(IgniteUser igniteUser);
    //IgniteUser getUser(Long id);
    List<UserDto> getAllUsers();

    Integer getNumberOfRecord();

    void addAll(List<UserDto> userDtoList);

    String addManyIgniteUsers(Long count);

    void deleteAllFromCache();
}