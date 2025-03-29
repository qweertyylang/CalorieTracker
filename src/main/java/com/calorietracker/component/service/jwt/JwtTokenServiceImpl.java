package com.calorietracker.component.service.jwt;

import com.calorietracker.component.response.RefreshTokenResponse;
import com.calorietracker.security.userdetails.AuthenticationUser;
import com.calorietracker.security.userdetails.UserDetailsService;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private final JwtEncoder jwtEncoder;

    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtTokenServiceImpl(
        JwtEncoder jwtEncoder,
        UserDetailsService userDetailsService
    ) {
        super();
        this.jwtEncoder = jwtEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String generateAccessToken(AuthenticationUser authenticationUser) {
        Instant now = Instant.now();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(8, ChronoUnit.HOURS))
            .subject(authenticationUser.getUsername())
            .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    @Override
    public String generateRefreshToken(AuthenticationUser authenticationUser) {
        Instant now = Instant.now();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(7, ChronoUnit.DAYS))
            .subject(authenticationUser.getUsername())
            .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    @Override
    public String parseToken(String token) {
        try {
            SignedJWT decodedJWT = SignedJWT.parse(token);
            return decodedJWT.getJWTClaimsSet().getSubject();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RefreshTokenResponse refreshToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String refreshToken = header.substring("Bearer ".length());

        String email = this.parseToken(refreshToken);
        AuthenticationUser authenticationUser = (AuthenticationUser) this.userDetailsService.loadUserByUsername(email);
        String refreshTokenValue = this.generateRefreshToken(authenticationUser);
        String accessTokenValue = this.generateAccessToken(authenticationUser);

        return new RefreshTokenResponse()
            .setRefreshToken(refreshTokenValue)
            .setAccessToken(accessTokenValue);
    }
}
