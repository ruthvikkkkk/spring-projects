package com.example.ignitepostgresmongo.repository;

import com.example.ignitepostgresmongo.entity.PostgresUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresUserRepository extends JpaRepository<PostgresUser, Long> {
}
