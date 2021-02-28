package com.vinsguru.cacheaside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheAsideApplication {

	//http://127.0.0.1:8081/ to see RedisCommander
	public static void main(String[] args) {
		SpringApplication.run(CacheAsideApplication.class, args);
	}

}
