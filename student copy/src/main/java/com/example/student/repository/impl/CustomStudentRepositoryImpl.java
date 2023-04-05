package com.example.student.repository.impl;

import com.example.student.repository.CustomStudentRepository;
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
