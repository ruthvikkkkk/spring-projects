package com.myexamples.reactivetwo.reactivetwo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "directors")
public class Director {

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private  Integer age;
}
