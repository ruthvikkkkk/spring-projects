package com.example.studentproject.mongoStudent.controller;

import com.example.studentproject.mongoStudent.DTO.StudentDTO;
import com.example.studentproject.mongoStudent.entity.Student;
import com.example.studentproject.mongoStudent.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") String id){
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(studentService.get(id), studentDTO);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addOrUpdate(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return new ResponseEntity<>((Student)studentService.addOrUpdate(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.OK);
    }
}
