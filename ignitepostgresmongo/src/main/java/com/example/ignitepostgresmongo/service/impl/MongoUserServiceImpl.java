package com.example.ignitepostgresmongo.service.impl;

import com.example.ignitepostgresmongo.entity.MongoUser;
import com.example.ignitepostgresmongo.repository.MongoDBUserRepository;
import com.example.ignitepostgresmongo.service.MongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoUserServiceImpl implements MongoUserService {
    @Autowired
    MongoDBUserRepository userRepository;

    @Override
    public MongoUser addUser(MongoUser mongoUser) {
        return userRepository.save(mongoUser);
    }

    @Override
    public Integer getNumberOfDocuments() {
        return userRepository.findAll().size();
    }

    @Override
    public void addAll(List<MongoUser> mongoUserList) {
        userRepository.saveAll(mongoUserList);
    }
}
