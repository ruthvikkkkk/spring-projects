package com.example.student.postgresStudent.controller;

import com.example.student.postgresStudent.entity.Student;
import com.example.student.postgresStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/poststudent")
public class PostStudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/postadd")
    public ResponseEntity<Student> add(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addOrUpdate(student), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") String id){
        return new ResponseEntity<>(studentService.get(Long.parseLong(id)), HttpStatus.OK);
    }
}
