package com.example.ignitepostgresmongo.service;

import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.MongoUser;
import com.example.ignitepostgresmongo.entity.PostgresUser;

import java.util.List;

public interface MongoUserService {
    MongoUser addUser(MongoUser mongoUser);

    Integer getNumberOfDocuments();

    void addAll(List<MongoUser> mongoUserList);
}