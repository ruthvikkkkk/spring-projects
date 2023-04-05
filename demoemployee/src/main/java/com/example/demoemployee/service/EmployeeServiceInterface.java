package com.example.demoemployee.service;

import com.example.demoemployee.Employee;
import com.example.demoemployee.entity.EmployeeEntity;

import java.util.Optional;

public interface EmployeeServiceInterface {
    public Optional<EmployeeEntity> getEmployee(String id);
    public boolean deleteEmployeeById(String id);
    public boolean updateEmployee(Employee name, String id);
    public void addEmployee(Employee employee);
    public Iterable<EmployeeEntity> findAll();
    //public Optional<EmployeeEntity[]> getEmployeeByLastName();
}
