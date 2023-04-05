package com.example.mongodemo.repository;

import com.example.mongodemo.entity.Employee;

import java.util.List;

public interface CustomEmployeeRepository {
    List<Employee> findByFirstNameLastNameCustom(String firstName, String lastName);
}
