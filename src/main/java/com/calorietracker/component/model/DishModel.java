package com.calorietracker.component.model;

import org.springframework.hateoas.RepresentationModel;

public class DishModel extends RepresentationModel<DishModel> {

    private String name;

    private int calories;

    private int proteins;

    private int fats;

    private int carbs;

    public String getName() {
        return name;
    }

    public DishModel setName(String name) {
        this.name = name;
        return this;
    }

    public int getCalories() {
        return calories;
    }

    public DishModel setCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public int getProteins() {
        return proteins;
    }

    public DishModel setProteins(int proteins) {
        this.proteins = proteins;
        return this;
    }

    public int getFats() {
        return fats;
    }

    public DishModel setFats(int fats) {
        this.fats = fats;
        return this;
    }

    public int getCarbs() {
        return carbs;
    }

    public DishModel setCarbs(int carbs) {
        this.carbs = carbs;
        return this;
    }
}
