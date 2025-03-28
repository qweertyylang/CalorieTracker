package com.calorietracker.component.service.user;

import com.calorietracker.component.request.SignUpRequest;
import com.calorietracker.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    User getByEmail(String email);

    User register(SignUpRequest request);

    User getCurrentUser();
}
