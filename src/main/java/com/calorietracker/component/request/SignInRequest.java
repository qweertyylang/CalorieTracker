package com.calorietracker.component.request;

public class SignInRequest {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public SignInRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SignInRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
