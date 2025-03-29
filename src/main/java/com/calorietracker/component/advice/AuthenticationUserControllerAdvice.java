package com.calorietracker.component.advice;

import com.calorietracker.component.assembler.UserModelAssembler;
import com.calorietracker.component.controller.api.CaloriesRestController;
import com.calorietracker.component.model.UserModel;
import com.calorietracker.component.service.user.UserService;
import com.calorietracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = CaloriesRestController.class)
public class AuthenticationUserControllerAdvice {

    private final UserService userService;

    private final UserModelAssembler userModelAssembler;

    @Autowired
    public AuthenticationUserControllerAdvice(UserService userService, UserModelAssembler userModelAssembler) {
        this.userService = userService;
        this.userModelAssembler = userModelAssembler;
    }

    @ModelAttribute("authUser")
    public UserModel getUserModel() {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder
            .getContext()
            .getAuthentication();

        String email = jwtAuthenticationToken.getToken().getSubject();
        User user = this.userService.getByEmail(email);

        return this.userModelAssembler.toModel(user);
    }
}
