package com.calorietracker.component.controller;

import com.calorietracker.component.request.SignUpRequest;
import com.calorietracker.component.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/sign-up")
public class SignUpController {

    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> signUp(
        @Validated @RequestBody SignUpRequest signUpRequest,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(bindingResult.getAllErrors());
        }

        this.userService.register(signUpRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
