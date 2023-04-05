package com.example.mongodemo.service.impl;

import com.example.mongodemo.entity.Employee;
import com.example.mongodemo.repository.EmployeeRepository;
import com.example.mongodemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    //@CacheEvict(cacheNames = "employees", key = "#employee.id")
    public Employee insertOrUpdate(Employee employee){
        if(employee.getId() == null){
            System.out.println("cache evict");
            employee.setId(UUID.randomUUID().toString());
        }
        return (Employee) employeeRepository.save(employee);
    }

    //@Cacheable(value = "employees", key = "#id")
    public Optional<Employee> findOne(String id){
        if(employeeRepository.existsById(id)) {
            System.out.println("outside cache");
            return employeeRepository.findById(id);
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public boolean existsByFirstName(String firstName) {
        return employeeRepository.existsByFirstName(firstName);
    }

    public List<Employee> findByFirstNameOrLastName(String firstName, String lastName){
        return employeeRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }
}
