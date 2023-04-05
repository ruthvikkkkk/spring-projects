package com.example.student.postgresStudent.service.impl;

import com.example.student.postgresStudent.entity.Instructor;
import com.example.student.postgresStudent.repository.PostInstructorRepository;
import com.example.student.postgresStudent.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostInstructorServiceImpl implements InstructorService {

    @Autowired
    PostInstructorRepository postInstructorRepository;

    @Override
    public Instructor addOrUpdate(Instructor instructor) {
        return postInstructorRepository.save(instructor);
    }

    @Override
    public Boolean deleteById(String id) {
        if(postInstructorRepository.existsById(id)){
            postInstructorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Instructor get(String id) {
        Optional<Instructor> optionalInstructor = postInstructorRepository.findById(id);
        if(optionalInstructor.isPresent()){
            Instructor instructor = optionalInstructor.get();
            return instructor;
        }
        return null;
    }
}
