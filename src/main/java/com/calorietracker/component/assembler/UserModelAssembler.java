package com.calorietracker.component.assembler;

import com.calorietracker.component.model.UserModel;
import com.calorietracker.entity.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler extends AbstractModelAssembler<User, UserModel>{

    @Override
    @NonNull
    public UserModel toModel(
        @NonNull User entity
    ) {
        UserModel userModel = new UserModel();

        userModel.setAge(entity.getAge())
            .setEmail(entity.getEmail())
            .setHeight(entity.getHeight())
            .setName(entity.getName())
            .setWeight(entity.getWeight())
            .setTarget(entity.getTarget());

        return userModel;
    }
}
