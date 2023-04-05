package com.example.reactivecommand.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Movie.COLLECTION_NAME)
@Data
@ToString
public class Movie{
    public static final String COLLECTION_NAME = "movies";
    String name;
    Director director;
}