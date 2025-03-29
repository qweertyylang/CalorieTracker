package com.calorietracker.validator;

import com.calorietracker.component.request.SignInRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignInValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return SignInRequest.class.equals(clazz);
    }

    @Override
    public void validate(
        @NonNull Object target,
        @NonNull Errors errors
    ) {
        SignInRequest signInRequest = (SignInRequest) target;

        if (StringUtils.isBlank(signInRequest.getEmail())) {
            errors.rejectValue(
                "email",
                "error.signin.email.empty"
            );
        }

        if (StringUtils.isBlank(signInRequest.getPassword())) {
            errors.rejectValue(
                "password",
                "error.signin.password.empty"
            );
        }
    }
}
