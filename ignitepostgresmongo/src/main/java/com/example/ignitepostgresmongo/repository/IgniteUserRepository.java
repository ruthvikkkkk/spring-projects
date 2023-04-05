package com.example.ignitepostgresmongo.repository;

import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.IgniteUser;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryConfig(cacheName = "userCache")
public interface IgniteUserRepository extends CrudRepository<UserDto, Long> {
}
