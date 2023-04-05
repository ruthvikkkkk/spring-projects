package com.example.ignitepostgresmongo.service;

import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.PostgresUser;
import java.util.List;

public interface PostgresUserService {
    PostgresUser addUser(UserDto user);
    String addManyUsers(Long count);
    Integer getNumberOfRecords();
    void addAll(List<PostgresUser> postgresUserList);
}