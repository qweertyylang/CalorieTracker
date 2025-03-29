package com.calorietracker.component.controller.api;

import com.calorietracker.component.assembler.DishModelAssembler;
import com.calorietracker.component.model.DishModel;
import com.calorietracker.component.request.DishCreateRequest;
import com.calorietracker.component.service.dish.DishService;
import com.calorietracker.component.service.user.UserService;
import com.calorietracker.entity.Dish;
import com.calorietracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dishes")
public class DishRestController {

    private final DishService dishService;

    private final UserService userService;

    private final DishModelAssembler dishModelAssembler;

    @Autowired
    public DishRestController(
        DishService dishService,
        UserService userService,
        DishModelAssembler dishModelAssembler
    ) {
        this.dishService = dishService;
        this.userService = userService;
        this.dishModelAssembler = dishModelAssembler;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDish(
        @RequestBody DishCreateRequest createRequest,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        User user = this.userService.getById(createRequest.getUserId());
        Dish dish = this.dishService.createDish(createRequest, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(dish);
    }

    @GetMapping("/{userId}")
    public List<DishModel> allDishes(
        @PathVariable Long userId
    ) {
        List<Dish> dishes = this.dishService.getAllByUserId(userId);

        return this.dishModelAssembler.toModelList(dishes);
    }
}
