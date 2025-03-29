package com.calorietracker.component.controller.api;

import com.calorietracker.component.model.UserModel;
import com.calorietracker.component.service.calories.CaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calories")
public class CaloriesRestController {

    private final CaloriesService caloriesService;

    @Autowired
    public CaloriesRestController(
        CaloriesService caloriesService
    ) {
        this.caloriesService = caloriesService;
    }

    @GetMapping("/calculate")
    public double calculateCalories(
        @ModelAttribute("authUser") UserModel authUser
    ) {
        return this.caloriesService.calculateCalories(authUser.getAge(), authUser.getWeight(), authUser.getHeight());
    }
}
