package com.example.student.service;

import com.example.student.DTO.InstructorDTO;
import com.example.student.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor addOrUpdate(InstructorDTO instructorDTO);
    Instructor get(String id);
    Boolean deleteById(String id);
    List<Instructor> findAll();
}
