package com.example.mongodemo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@ToString
//@Document(collection = Address.collectionName)
public class Address {

    public static final String collectionName = "employeeAddress";
    private Integer id;
    private String lineNumber1;
    private String lineNumber2;
    private String zipCode;
    private String state;
    private String city;
    private String country;
    private String addressType;
}
