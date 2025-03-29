package com.calorietracker.component.controller.api;

import com.calorietracker.component.request.SignInRequest;
import com.calorietracker.component.response.RefreshTokenResponse;
import com.calorietracker.component.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/sign-in")
public class SignInRestController {

    private final AuthenticationService authenticationService;

    @Autowired
    public SignInRestController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<?> signIn(
        @RequestBody SignInRequest signInRequest
    ) {
        RefreshTokenResponse refreshTokenResponse = this.authenticationService.signIn(signInRequest);

        return ResponseEntity.ok(refreshTokenResponse);
    }
}
