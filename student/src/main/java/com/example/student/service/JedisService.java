package com.example.student.service;

import com.example.student.entity.isMongo;

public interface JedisService {
    Boolean get();
    isMongo set(Boolean bool);
}
