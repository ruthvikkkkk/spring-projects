package com.example.ignitepostgresmongo.entity;

import lombok.Data;
import lombok.ToString;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

@Data
@ToString
public class IgniteUser implements Serializable {


    @QuerySqlField(index = true)
    private Long id;

    @QuerySqlField(index = true)
    private String name;

    @QuerySqlField(index = true)
    private Integer age;
}
