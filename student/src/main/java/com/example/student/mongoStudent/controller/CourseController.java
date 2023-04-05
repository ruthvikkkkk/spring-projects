package com.example.student.mongoStudent.controller;

import com.example.student.mongoStudent.DTO.CourseDTO;
import com.example.student.mongoStudent.entity.Course;
import com.example.student.mongoStudent.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/get/{id}")
    public ResponseEntity<CourseDTO> get(@PathVariable("id") String id){
        CourseDTO courseDTO = new CourseDTO();
        BeanUtils.copyProperties(courseService.get(id), courseDTO);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> add(@RequestBody Course course){
        CourseDTO courseDTO = new CourseDTO();
        BeanUtils.copyProperties(course, courseDTO);
        return new ResponseEntity<>(courseService.addOrUpdate(courseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(courseService.deleteById(id), HttpStatus.OK);
    }
}
