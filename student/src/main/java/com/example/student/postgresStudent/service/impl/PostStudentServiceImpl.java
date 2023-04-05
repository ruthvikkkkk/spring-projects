package com.example.student.postgresStudent.service.impl;


import com.example.student.postgresStudent.entity.Student;
import com.example.student.postgresStudent.repository.PostStudentRepository;
import com.example.student.postgresStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostStudentServiceImpl implements StudentService {

    @Autowired
    PostStudentRepository postStudentRepository;

    @Override
    public Student addOrUpdate(Student student) {
        return postStudentRepository.save(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        if(postStudentRepository.existsById(id)){
            postStudentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student get(Long id) {
        Optional<Student> optionalStudent = postStudentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            return student;
        }
        return null;
    }
}
