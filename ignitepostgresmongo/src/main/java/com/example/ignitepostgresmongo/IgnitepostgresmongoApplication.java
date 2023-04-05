package com.example.ignitepostgresmongo;

import com.example.ignitepostgresmongo.entity.IgniteUser;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableMongoRepositories
public class IgnitepostgresmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgnitepostgresmongoApplication.class, args);
	}

}
