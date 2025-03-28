package com.calorietracker.security.userdetails;

import com.calorietracker.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

public class AuthenticationUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public static AuthenticationUser of(User user, Collection<? extends GrantedAuthority> authorities) {
        return new AuthenticationUser(user, authorities);
    }

    private AuthenticationUser(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}
