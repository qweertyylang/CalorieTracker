package com.calorietracker.repository;

import com.calorietracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @NonNull
    User save(@NonNull User user);

    Optional<User> findById(@NonNull Long id);

    Optional<User> findByEmail(String email);
}
