package com.calorietracker.validator;

import com.calorietracker.component.request.SignUpRequest;
import com.calorietracker.component.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignUpValidator implements Validator {

    private final UserService userService;

    @Autowired
    public SignUpValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(
        @NonNull Class<?> clazz
    ) {
        return SignUpRequest.class.equals(clazz);
    }

    @Override
    public void validate(
        @NonNull Object target,
        @NonNull Errors errors
    ) {
        SignUpRequest signUpRequest = (SignUpRequest) target;

        if (StringUtils.isBlank(signUpRequest.getName())) {
            errors.rejectValue(
                "name",
                "error.signup.name.empty"
            );
        }

        if (StringUtils.isBlank(signUpRequest.getEmail())) {
            errors.rejectValue(
                "email",
                "error.signup.email.empty"
            );
        }

        if (StringUtils.isBlank(signUpRequest.getPassword())) {
            errors.rejectValue(
                "password",
                "error.signup.password.empty"
            );
        }

        if (StringUtils.isBlank(signUpRequest.getTarget())) {
            errors.rejectValue(
                "target",
                "error.signup.target.empty"
            );
            return;
        }

        if (signUpRequest.getAge() <= 0 || signUpRequest.getAge() > 120) {
            errors.rejectValue(
                "age",
                "error.signup.age.invalid"
            );
        }

        if (signUpRequest.getWeight() <= 0 || signUpRequest.getWeight() > 400) {
            errors.rejectValue(
                "weight",
                "error.signup.weight.invalid"
            );
        }

        if (signUpRequest.getHeight() <= 0 || signUpRequest.getHeight() > 230) {
            errors.rejectValue(
                "height",
                "error.signup.height.invalid"
            );
            return;
        }

        if (this.userService.findByEmail(signUpRequest.getEmail()).isPresent()) {
            errors.rejectValue(
                "email",
                "error.signup.email.exist"
            );
        }
    }
}
