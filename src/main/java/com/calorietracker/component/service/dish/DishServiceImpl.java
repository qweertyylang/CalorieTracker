package com.calorietracker.component.service.dish;

import com.calorietracker.component.request.DishCreateRequest;
import com.calorietracker.entity.Dish;
import com.calorietracker.entity.User;
import com.calorietracker.repository.DishRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Optional<Dish> findByUserId(Long userId) {
        return this.dishRepository.findByUserId(userId);
    }

    @Override
    public Dish getByUserId(Long userId) {
        return this.dishRepository.findByUserId(userId)
            .orElseThrow(
                () -> new EntityNotFoundException("dish not found")
            );
    }

    @Override
    public List<Dish> getAllByUserId(Long userId) {
        return this.dishRepository.getAllByUserId(userId);
    }

    @Override
    public Dish createDish(DishCreateRequest createRequest, User user) {
        Dish dish = new Dish();

        dish.setUser(user)
            .setUserId(user.getId()).setName(createRequest.getName())
            .setCalories(createRequest.getCalories())
            .setProteins(createRequest.getProteins())
            .setFats(createRequest.getFats())
            .setCarbs(createRequest.getCarbs());

        return this.dishRepository.save(dish);
    }
}
