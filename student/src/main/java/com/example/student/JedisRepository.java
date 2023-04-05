package com.example.student;

import com.example.student.entity.isMongo;
import org.springframework.data.repository.CrudRepository;

public interface JedisRepository extends CrudRepository<isMongo, String> {
}
