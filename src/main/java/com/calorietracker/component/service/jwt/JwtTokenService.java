package com.calorietracker.component.service.jwt;

import com.calorietracker.component.response.RefreshTokenResponse;
import com.calorietracker.security.userdetails.AuthenticationUser;
import jakarta.servlet.http.HttpServletRequest;

public interface JwtTokenService {

    String generateAccessToken(AuthenticationUser authenticationUser);

    String generateRefreshToken(AuthenticationUser authenticationUser);

    String parseToken(String token);

    RefreshTokenResponse refreshToken(HttpServletRequest request);
}
