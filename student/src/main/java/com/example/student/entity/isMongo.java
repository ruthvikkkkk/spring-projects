package com.example.student.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;


@Data
@ToString
@RedisHash
public class isMongo {
    @Id
    private String id = "isMongo";
    private Boolean bool;
}
