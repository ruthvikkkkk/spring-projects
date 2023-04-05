package com.example.ignitepostgresmongo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

import static org.yaml.snakeyaml.nodes.NodeId.sequence;

@Entity
@ToString
@Data
@Table
public class PostgresUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen")
    @SequenceGenerator(name = "idGen", sequenceName = "ids", initialValue = 1)
    private Long id;
    private String name;
    private Integer age;
}
