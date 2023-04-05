package com.example.mongodemo.repository.repoimpl;

import com.example.mongodemo.entity.Employee;
import com.example.mongodemo.repository.CustomEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Employee> findByFirstNameLastNameCustom(String firstName, String lastName) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("firstName").is(firstName), Criteria.where("lastName").is(lastName));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Employee.class);
    }
}
