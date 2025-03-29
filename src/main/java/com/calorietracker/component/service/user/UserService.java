package com.calorietracker.component.service.user;

import com.calorietracker.component.request.SignUpRequest;
import com.calorietracker.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    User getByEmail(String email);

    User getById(Long id);

    User register(SignUpRequest request);

    User getCurrentUser();
}
