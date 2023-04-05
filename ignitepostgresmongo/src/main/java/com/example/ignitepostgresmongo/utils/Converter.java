package com.example.ignitepostgresmongo.utils;

import com.example.ignitepostgresmongo.dto.UserDto;
import com.example.ignitepostgresmongo.entity.IgniteUser;
import com.example.ignitepostgresmongo.entity.MongoUser;
import com.example.ignitepostgresmongo.entity.PostgresUser;
import javafx.geometry.Pos;
import org.apache.ignite.Ignite;
import org.springframework.beans.BeanUtils;

public class Converter {

    public static MongoUser toMongoUserEntity(UserDto userDto){
        MongoUser mongoUser = new MongoUser();
        BeanUtils.copyProperties(userDto, mongoUser);
        return mongoUser;
    }

    public static PostgresUser toPostgresUserEntity(UserDto userDto){
        PostgresUser postgresUser = new PostgresUser();
        BeanUtils.copyProperties(userDto, postgresUser);
        return postgresUser;
    }

    public static UserDto toUserDto(Object obj){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(obj, userDto);
        return userDto;
    }

    public static MongoUser toMongoUser(PostgresUser postgresUser){
        MongoUser mongoUser = new MongoUser();
        BeanUtils.copyProperties(postgresUser, mongoUser);
        return mongoUser;
    }

    public static IgniteUser toIgniteUser(PostgresUser postgresUser){
        IgniteUser igniteUser = new IgniteUser();
        BeanUtils.copyProperties(postgresUser, igniteUser);
        return igniteUser;
    }

    public static PostgresUser toPostgresUser(IgniteUser igniteUser){
        PostgresUser postgresUser = new PostgresUser();
        BeanUtils.copyProperties(igniteUser, postgresUser);
        return postgresUser;
    }

    public static MongoUser toMongoUserFromIgnite(IgniteUser igniteUser){
        MongoUser mongoUser = new MongoUser();
        BeanUtils.copyProperties(igniteUser, mongoUser);
        return mongoUser;
    }
}
