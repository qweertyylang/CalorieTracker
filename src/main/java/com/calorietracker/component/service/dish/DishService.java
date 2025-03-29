package com.calorietracker.component.service.dish;

import com.calorietracker.component.request.DishCreateRequest;
import com.calorietracker.entity.Dish;
import com.calorietracker.entity.User;

import java.util.List;
import java.util.Optional;

public interface DishService {

    Optional<Dish> findByUserId(Long userId);

    Dish getByUserId(Long userId);

    List<Dish> getAllByUserId(Long userId);

    Dish createDish(DishCreateRequest createRequest, User user);

}
