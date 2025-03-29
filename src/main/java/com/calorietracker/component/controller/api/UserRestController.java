package com.calorietracker.component.controller.api;

import com.calorietracker.component.assembler.UserModelAssembler;
import com.calorietracker.component.model.UserModel;
import com.calorietracker.component.service.user.UserService;
import com.calorietracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/user")
public class UserRestController {

    private final UserService userService;

    private final UserModelAssembler userModelAssembler;

    @Autowired
    public UserRestController(UserService userService, UserModelAssembler userModelAssembler) {
        this.userService = userService;
        this.userModelAssembler = userModelAssembler;
    }

    @GetMapping
    public UserModel getAuthUser() {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder
            .getContext()
            .getAuthentication();

        String email = jwtAuthenticationToken.getToken().getSubject();
        User user = this.userService.getByEmail(email);

        return this.userModelAssembler.toModel(user);
    }
}
