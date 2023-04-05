package com.example.demoemployee.controller;

import com.example.demoemployee.Company;
import com.example.demoemployee.Employee;
import com.example.demoemployee.entity.EmployeeEntity;
import com.example.demoemployee.service.EmployeeServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceInterface employeeService;

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeeById(@PathVariable("empId") String id){
        Employee employee = new Employee();
        Optional<EmployeeEntity> employeeFound =  employeeService.getEmployee(id);
        ArrayList<Company> companies = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            Company company = new Company();
        }

        if(employeeFound.isPresent()) {
            BeanUtils.copyProperties(employeeFound.get(), employee);
        }
        return new ResponseEntity<String>(employee.toString(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employeeTransfer){
        Employee myEmployee = new Employee();
        BeanUtils.copyProperties(employeeTransfer, myEmployee);
        employeeService.addEmployee(myEmployee);

        return new ResponseEntity<String>("Created Employee with id : " + myEmployee.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") String id){
        if(employeeService.deleteEmployeeById(id)){
            return new ResponseEntity<String>("Deleted Employee with id : " + id, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Employee with id : " + id + " not Found!", HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Boolean> updateEmployeeName(@RequestBody Employee employeeTransfer, @PathVariable("empId") String id){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeTransfer, employee);
        return new ResponseEntity<Boolean>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<String> findAll(){
        return new ResponseEntity<String>(employeeService.findAll().toString(), HttpStatus.OK);
    }
}
