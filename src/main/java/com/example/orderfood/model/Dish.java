package com.example.orderfood.model;

import javax.persistence.*;

@Entity
@Table(name="DISH")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    Integer id;
    @Column(name = "cuisine", nullable = false)
    String cuisine;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "price", nullable = false)
    float price;
    @Column(name = "stage", nullable = false)
    String stage;

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String dish) {
        this.stage = dish;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " " + "price:" + price;
    }
}
