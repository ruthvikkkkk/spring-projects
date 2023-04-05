package com.example.reactivecommand.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@ToString
public class Director{
    String name;
    Integer age;
}