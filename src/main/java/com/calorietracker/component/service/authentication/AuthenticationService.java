package com.calorietracker.component.service.authentication;

import com.calorietracker.component.request.SignInRequest;
import com.calorietracker.component.response.RefreshTokenResponse;
import com.calorietracker.component.service.jwt.JwtTokenService;
import com.calorietracker.security.userdetails.AuthenticationUser;
import com.calorietracker.security.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final JwtTokenService tokenService;

    @Autowired
    public AuthenticationService(
        AuthenticationManager authenticationManager,
        UserDetailsService userDetailsService,
        JwtTokenService tokenService
    ) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenService = tokenService;
    }

    public RefreshTokenResponse signIn(SignInRequest req) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        AuthenticationUser authenticationUser = (AuthenticationUser) userDetailsService.loadUserByUsername(req.getEmail());

        String accessToken = this.tokenService.generateAccessToken(authenticationUser);
        String refreshToken = this.tokenService.generateRefreshToken(authenticationUser);

        return new RefreshTokenResponse()
            .setAccessToken(accessToken)
            .setRefreshToken(refreshToken);
    }
}
