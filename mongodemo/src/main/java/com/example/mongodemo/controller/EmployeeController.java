package com.example.mongodemo.controller;

import DTO.EmployeeDTO;
import com.example.mongodemo.entity.Employee;
import com.example.mongodemo.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println(employeeDTO);

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        Employee employeeCreated =  employeeService.insertOrUpdate(employee);

        return new ResponseEntity<String>("Employee with id: " + employeeCreated.getId() + " created!", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> findOne(@PathVariable("id") String id){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Optional<Employee> optionalEmployee = employeeService.findOne(id);
        if(optionalEmployee.isPresent())
            BeanUtils.copyProperties(optionalEmployee.get(), employeeDTO);

        return new ResponseEntity<>(employeeDTO.toString(), HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<String> findAll(){
        List<Employee> employeeDTOList= employeeService.findAll();
        return new ResponseEntity<String>(employeeDTOList.toString(), HttpStatus.OK);
    }

    @GetMapping("/getbyfirstandlast/{firstName}/{lastName}")
    public ResponseEntity<String> findByFirstNameLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        List<Employee> optionalEmployee = employeeService.findByFirstNameAndLastName(firstName, lastName);
        return new ResponseEntity<String>(optionalEmployee.toString(), HttpStatus.OK);
    }

    @GetMapping("existsByName/{firstName}")
    public ResponseEntity<Boolean> existsBtFirstName(@PathVariable("firstName") String firstName){
        return new ResponseEntity<>(employeeService.existsByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/getbyfirstorlast/{firstName}/{lastName}")
    public ResponseEntity<String> findByFirstNameOrLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        List<Employee> optionalEmployee = employeeService.findByFirstNameOrLastName(firstName, lastName);
        return new ResponseEntity<>(optionalEmployee.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(String id){
        employeeService.deleteById(id);
    }
}
