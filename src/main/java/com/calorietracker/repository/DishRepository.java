package com.calorietracker.repository;

import com.calorietracker.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {

    @NonNull
    Dish save(@NonNull Dish dish);

    Optional<Dish> findByUserId(Long userId);

    List<Dish> getAllByUserId(Long userId);
}
