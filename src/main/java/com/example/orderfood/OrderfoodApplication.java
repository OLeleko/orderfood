package com.example.orderfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.orderfood")
@EnableJpaRepositories(basePackages = "com.example.orderfood")
public class OrderfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderfoodApplication.class, args);
	}

}
