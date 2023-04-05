package com.example.mongodemo.repository;

import com.example.mongodemo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository<T> extends MongoRepository<T, String> {

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    boolean existsByFirstName(String firstName);
    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);
}
