package com.calorietracker.component.controller.api;

import com.calorietracker.component.request.SignInRequest;
import com.calorietracker.component.response.RefreshTokenResponse;
import com.calorietracker.component.service.authentication.AuthenticationService;
import com.calorietracker.validator.SignInValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/sign-in")
public class SignInRestController {

    private final AuthenticationService authenticationService;

    private final SignInValidator signInValidator;

    @Autowired
    public SignInRestController(AuthenticationService authenticationService, SignInValidator signInValidator) {
        this.authenticationService = authenticationService;
        this.signInValidator = signInValidator;
    }

    @InitBinder("signInRequest")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(this.signInValidator);
    }

    @PostMapping
    public ResponseEntity<?> signIn(
        @RequestBody SignInRequest signInRequest
    ) {
        RefreshTokenResponse refreshTokenResponse = this.authenticationService.signIn(signInRequest);

        return ResponseEntity.ok(refreshTokenResponse);
    }
}
