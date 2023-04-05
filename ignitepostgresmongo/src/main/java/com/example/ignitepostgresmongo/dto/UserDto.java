package com.example.ignitepostgresmongo.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserDto implements Serializable {
    private String name;
    private Integer age;
}
