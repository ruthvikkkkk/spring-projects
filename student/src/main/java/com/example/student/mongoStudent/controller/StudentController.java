package com.example.student.mongoStudent.controller;


import com.example.student.mongoStudent.DTO.StudentDTO;
import com.example.student.mongoStudent.entity.Student;
import com.example.student.mongoStudent.service.StudentService;
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
    public ResponseEntity<Student> get(@PathVariable("id") String id){
        Student student = studentService.get(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> add(@RequestBody Student student){
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        return new ResponseEntity<>(studentService.addOrUpdate(studentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.OK);
    }
}