package com.calorietracker.component.request;

public class DishCreateRequest {

    private String name;

    private int calories;

    private int proteins;

    private int fats;

    private int carbs;

    private Long userId;

    public String getName() {
        return name;
    }

    public DishCreateRequest setName(String name) {
        this.name = name;
        return this;
    }

    public int getCalories() {
        return calories;
    }

    public DishCreateRequest setCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public int getProteins() {
        return proteins;
    }

    public DishCreateRequest setProteins(int proteins) {
        this.proteins = proteins;
        return this;
    }

    public int getFats() {
        return fats;
    }

    public DishCreateRequest setFats(int fats) {
        this.fats = fats;
        return this;
    }

    public int getCarbs() {
        return carbs;
    }

    public DishCreateRequest setCarbs(int carbs) {
        this.carbs = carbs;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public DishCreateRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
