package com.calorietracker.validator;

import com.calorietracker.component.request.DishCreateRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DishCreateValidator implements Validator {
    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return DishCreateRequest.class.equals(clazz);
    }

    @Override
    public void validate(
        @NonNull Object target,
        @NonNull Errors errors
    ) {
        DishCreateRequest dishCreateRequest = (DishCreateRequest) target;

        if (StringUtils.isBlank(dishCreateRequest.getName())) {
            errors.rejectValue(
                "name",
                "error.dish.name.empty"
            );
        }

        if (dishCreateRequest.getCalories() <= 0) {
            errors.rejectValue(
                "calories",
                "error.dish.calories.invalid"
            );
        }

        if (dishCreateRequest.getProteins() < 0 || dishCreateRequest.getProteins() > 1000) {
            errors.rejectValue(
                "proteins",
                "error.dish.proteins.invalid"
            );
        }

        if (dishCreateRequest.getFats() < 0 || dishCreateRequest.getFats() > 1000) {
            errors.rejectValue(
                "fats",
                "error.dish.fats.invalid"
            );
        }

        if (dishCreateRequest.getCarbs() < 0 || dishCreateRequest.getCarbs() > 1000) {
            errors.rejectValue(
                "carbs",
                "error.dish.carbs.invalid"
            );
        }
    }
}
