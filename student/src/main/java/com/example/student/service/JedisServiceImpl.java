package com.example.student.service;

import com.example.student.JedisRepository;
import com.example.student.entity.isMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JedisServiceImpl implements JedisService {

    @Autowired
    JedisRepository jedisRepository;

    @Override
    public Boolean get() {
        Optional<isMongo> booleanOptional =  jedisRepository.findById("isMongo");
        if(booleanOptional.isPresent()){
            return booleanOptional.get().getBool();
        }
        return null;
    }

    @Override
    public isMongo set(Boolean mongoBool) {
        Optional<isMongo> mongo = jedisRepository.findById("isMongo");
        if(mongo.isPresent()){
            isMongo isMongo = mongo.get();
            isMongo.setBool(mongoBool);
            return jedisRepository.save(isMongo);
        }
        isMongo isMongo = new isMongo();

        isMongo.setBool(mongoBool);
        return jedisRepository.save(isMongo);

    }
}
