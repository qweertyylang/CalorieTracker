package com.calorietracker.component.assembler;

import com.calorietracker.component.model.DishModel;
import com.calorietracker.entity.Dish;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DishModelAssembler extends AbstractModelAssembler<Dish, DishModel> {

    @Override
    @NonNull
    public DishModel toModel(
        @NonNull Dish entity
    ) {
        DishModel dishModel = new DishModel();

        dishModel.setCalories(entity.getCalories())
            .setFats(entity.getFats())
            .setProteins(entity.getProteins())
            .setCarbs(entity.getCarbs())
            .setName(entity.getName());

        return dishModel;
    }
}
