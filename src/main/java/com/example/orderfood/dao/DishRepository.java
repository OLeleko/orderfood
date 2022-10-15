package com.example.orderfood.dao;

import com.example.orderfood.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    public List<Dish> findDishesByCuisineAndStage(String cuisine, String stage);
}
