package com.example.student.mongoStudent.service.impl;

import com.example.student.mongoStudent.DTO.InstructorDTO;
import com.example.student.mongoStudent.entity.Instructor;
import com.example.student.mongoStudent.repository.InstructorRepository;
import com.example.student.mongoStudent.service.InstructorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public Instructor addOrUpdate(InstructorDTO instructorDTO) {
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(instructorDTO, instructor);
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor get(String id) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
        if(optionalInstructor.isPresent())
            return optionalInstructor.get();
        return null;
    }

    @Override
    public Boolean deleteById(String id) {
        if(instructorRepository.existsById(id)){
            instructorRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
