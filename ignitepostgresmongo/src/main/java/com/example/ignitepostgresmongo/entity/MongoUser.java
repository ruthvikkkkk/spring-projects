package com.example.ignitepostgresmongo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Document
@Data
@ToString
public class MongoUser implements Serializable {

    @Id
    private Long id;
    private String name;
    private Integer age;
}
