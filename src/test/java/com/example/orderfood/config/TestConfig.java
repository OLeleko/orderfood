package com.example.orderfood.config;

import com.example.orderfood.service.DishService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {
    @Bean
    @Primary
    public DishService dishService(){

        return mock(DishService.class);
    }
}
