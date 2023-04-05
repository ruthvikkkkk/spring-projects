package com.example.mongodemo.entity;

import lombok.Data;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@ToString
@Document(collection = Employee.COLLECTION_NAME)
public class Employee {

    public static final String COLLECTION_NAME = "employee";

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private Boolean isActive;
    private Address address;
}
