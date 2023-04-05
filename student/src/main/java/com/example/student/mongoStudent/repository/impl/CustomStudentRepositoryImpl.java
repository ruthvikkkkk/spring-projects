package com.example.student.mongoStudent.repository.impl;

import com.example.student.mongoStudent.repository.CustomStudentRepository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    @Override
    public Integer findCountOfStudentsInCourse() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        return null;
    }
}
