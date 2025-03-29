package com.calorietracker.component.model;

import org.springframework.hateoas.RepresentationModel;

public class UserModel extends RepresentationModel<UserModel> {

    private String name;

    private String email;

    private int age;

    private double weight;

    private double height;

    private String target;

    public String getName() {
        return name;
    }

    public UserModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserModel setAge(int age) {
        this.age = age;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public UserModel setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public UserModel setHeight(double height) {
        this.height = height;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public UserModel setTarget(String target) {
        this.target = target;
        return this;
    }
}
