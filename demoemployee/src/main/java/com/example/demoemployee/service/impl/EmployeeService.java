package com.example.demoemployee.service.impl;

import com.example.demoemployee.Employee;
import com.example.demoemployee.datarepository.EmployeeRepository;
import com.example.demoemployee.entity.EmployeeEntity;
import com.example.demoemployee.service.EmployeeServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Optional<EmployeeEntity> getEmployee(String id) {
//        System.out.println("this is the id inside service method : " + id);
//        Employee employee = new Employee();
//        EmployeeEntity employeeEntity = new EmployeeEntity();
//        BeanUtils.copyProperties(employeeRepository.findById(id), employeeEntity);
//        System.out.println("this is the employee entity id : " + employeeEntity.getId());
//        return employeeEntity;

        return employeeRepository.findById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee, String id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            EmployeeEntity employeeEntity = new EmployeeEntity();
            BeanUtils.copyProperties(employee, employeeEntity);
            employeeRepository.save(employeeEntity);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Iterable<EmployeeEntity> findAll(){
        return employeeRepository.findAll();
    }

//    @Override
//    public Optional<EmployeeEntity[]> getEmployeeByLastName() {
//        Iterable<EmployeeEntity> employeeEntities =
//    }
}
