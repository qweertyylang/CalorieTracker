package com.calorietracker.component.request;

public class SignUpRequest {

    private String name;

    private String email;

    private String password;

    private int age;

    private double weight;

    private double height;

    private String target;

    public String getName() {
        return name;
    }

    public SignUpRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SignUpRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SignUpRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getAge() {
        return age;
    }

    public SignUpRequest setAge(int age) {
        this.age = age;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public SignUpRequest setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public SignUpRequest setHeight(double height) {
        this.height = height;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public SignUpRequest setTarget(String target) {
        this.target = target;
        return this;
    }
}
