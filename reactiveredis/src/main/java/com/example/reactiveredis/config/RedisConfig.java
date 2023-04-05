package com.example.reactiveredis.config;

import com.example.reactiveredis.entity.IceCream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public ReactiveHashOperations<String, String, IceCream> hashOperations(ReactiveRedisConnectionFactory redisConnectionFactory){

        ReactiveRedisTemplate template = new ReactiveRedisTemplate<>(
                redisConnectionFactory,
                RedisSerializationContext.<String, IceCream>newSerializationContext(new StringRedisSerializer())
                        .hashKey(new GenericToStringSerializer<>(String.class))
                        .hashValue(new Jackson2JsonRedisSerializer<>(IceCream.class))
                        .build()
        );

        return template.opsForHash();
    }
}
