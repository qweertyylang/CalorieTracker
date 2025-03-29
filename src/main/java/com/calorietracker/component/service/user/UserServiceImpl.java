package com.calorietracker.component.service.user;

import com.calorietracker.component.request.SignUpRequest;
import com.calorietracker.entity.User;
import com.calorietracker.repository.UserRepository;
import com.calorietracker.security.userdetails.AuthenticationUser;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User getByEmail(String email) {
        return this.userRepository.findByEmail(email)
            .orElseThrow(
                () -> new EntityNotFoundException("user not found")
            );
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("user not found")
            );
    }

    @Override
    public User register(SignUpRequest request) {
        User user = new User();

        user.setEmail(request.getEmail())
            .setName(request.getName())
            .setAge(request.getAge())
            .setPassword(this.passwordEncoder.encode(request.getPassword()))
            .setWeight(request.getWeight())
            .setHeight(request.getHeight())
            .setTarget(request.getTarget());

        return this.userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        AuthenticationUser user =
            (AuthenticationUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        return this.getByEmail(user.getUsername());
    }
}
