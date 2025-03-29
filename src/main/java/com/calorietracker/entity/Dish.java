package com.calorietracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String calories;

    private String proteins;

    private String fats;

    private String carbs;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Dish setName(String name) {
        this.name = name;
        return this;
    }

    public String getCalories() {
        return calories;
    }

    public Dish setCalories(String calories) {
        this.calories = calories;
        return this;
    }

    public String getProteins() {
        return proteins;
    }

    public Dish setProteins(String proteins) {
        this.proteins = proteins;
        return this;
    }

    public String getFats() {
        return fats;
    }

    public Dish setFats(String fats) {
        this.fats = fats;
        return this;
    }

    public String getCarbs() {
        return carbs;
    }

    public Dish setCarbs(String carbs) {
        this.carbs = carbs;
        return this;
    }
}
