package com.example.studentproject.mongoStudent.service.impl;

import com.example.studentproject.mongoStudent.entity.Student;
import com.example.studentproject.mongoStudent.repository.SystemRepository;
import com.example.studentproject.mongoStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    SystemRepository studentRepository;

    @Override
    public Student addOrUpdate(Student student) {
        return (Student) studentRepository.save(student);
    }

    @Override
    public Boolean deleteById(String id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student get(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        return null;
    }
}
