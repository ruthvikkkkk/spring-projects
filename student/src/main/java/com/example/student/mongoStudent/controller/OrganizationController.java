package com.example.student.mongoStudent.controller;

import com.example.student.mongoStudent.entity.Instructor;
import com.example.student.mongoStudent.service.CourseService;
import com.example.student.mongoStudent.service.InstructorService;
import com.example.student.mongoStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorService instructorService;

    @GetMapping("/countOf/{id}")
    public ResponseEntity<String> countOf(@PathVariable("id") String s){
        if(s.equals("students")){
            return new ResponseEntity<>("number of students = " + studentService.findAll().size(), HttpStatus.OK);
        }else if(s.equals("instructors")){
            return new ResponseEntity<>("number of instructors = " + instructorService.findAll().size(), HttpStatus.OK);
        }else if(s.equals("courses")){
            return new ResponseEntity<>("number of courses = " + courseService.findAll().size(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("invalid path variable", HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteCourse/{id}}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(courseService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/instructorDetails")
    public ResponseEntity<List<Instructor>> getInstructors(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("courseid/{id}")
    public ResponseEntity<Map<String, String>> findByCourse(@PathVariable("id") String id){
        return new ResponseEntity<>(studentService.findByCourse(id), HttpStatus.OK);
    }

    @GetMapping("courseStatus/{id}")
    public ResponseEntity<Map<String, String>> findByStatus(@PathVariable("id") String status){
        return new ResponseEntity<>(studentService.findByCourseStatus(status), HttpStatus.OK);
    }
}
