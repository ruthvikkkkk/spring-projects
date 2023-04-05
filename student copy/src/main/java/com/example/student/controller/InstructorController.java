package com.example.student.controller;

import com.example.student.DTO.InstructorDTO;
import com.example.student.entity.Instructor;
import com.example.student.service.InstructorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @GetMapping("/get/{id}")
    public ResponseEntity<InstructorDTO> get(@PathVariable("id") String id){
        InstructorDTO instructorDTO = new InstructorDTO();
        BeanUtils.copyProperties(instructorService.get(id), instructorDTO);
        return new ResponseEntity<>(instructorDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Instructor> add(@RequestBody Instructor instructor){
        InstructorDTO instructorDTO = new InstructorDTO();
        BeanUtils.copyProperties(instructor, instructorDTO);
        return new ResponseEntity<>(instructorService.addOrUpdate(instructorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(instructorService.deleteById(id), HttpStatus.OK);
    }

}
