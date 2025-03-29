package com.calorietracker.component.service.calories;

import com.calorietracker.component.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class CaloriesServiceImpl implements CaloriesService {

    @Override
    public double calculateCalories(int age, double weight, double height) {
        return 88.36 + (11.3 * weight) + (3.9 * height) - (5 * age);
    }
}
