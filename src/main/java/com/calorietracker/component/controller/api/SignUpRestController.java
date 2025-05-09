package com.calorietracker.component.controller.api;

import com.calorietracker.component.request.SignUpRequest;
import com.calorietracker.component.service.user.UserService;
import com.calorietracker.validator.SignUpValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/sign-up")
public class SignUpRestController {

    private final UserService userService;

    private final SignUpValidator validator;

    @Autowired
    public SignUpRestController(UserService userService, SignUpValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @InitBinder("signUpRequest")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(this.validator);
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
