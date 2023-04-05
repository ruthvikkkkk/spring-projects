package com.example.mongodemo.service;

import com.example.mongodemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee insertOrUpdate(Employee employee);
    Optional<Employee> findOne(String id);
    List<Employee> findAll();
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    boolean existsByFirstName(String firstName);
    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);
    void deleteById(String id);
}
