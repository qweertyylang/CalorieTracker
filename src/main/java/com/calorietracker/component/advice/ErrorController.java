package com.calorietracker.component.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler({
        EntityNotFoundException.class
    })
    public <T extends RuntimeException> ResponseEntity<T> notFount(T ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ex);
    }
}
