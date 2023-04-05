package com.example.student.mongoStudent.service;

import com.example.student.mongoStudent.DTO.InstructorDTO;
import com.example.student.mongoStudent.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor addOrUpdate(InstructorDTO instructorDTO);
    Instructor get(String id);
    Boolean deleteById(String id);
    List<Instructor> findAll();
}
