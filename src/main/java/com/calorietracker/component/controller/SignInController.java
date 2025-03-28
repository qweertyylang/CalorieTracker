package com.calorietracker.component.controller;

import com.calorietracker.component.request.SignInRequest;
import com.calorietracker.component.response.RefreshTokenResponse;
import com.calorietracker.component.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/sign-in")
public class SignInController {

    private final AuthenticationService authenticationService;

    @Autowired
    public SignInController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<?> signIn(
        @RequestBody SignInRequest signInRequest
    ) {
        try {
            RefreshTokenResponse refreshTokenResponse = this.authenticationService.signIn(signInRequest);

            return ResponseEntity.ok(refreshTokenResponse);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
