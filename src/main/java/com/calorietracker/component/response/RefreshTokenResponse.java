package com.calorietracker.component.response;

public class RefreshTokenResponse {

    private String refreshToken;

    private String accessToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public RefreshTokenResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public RefreshTokenResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
