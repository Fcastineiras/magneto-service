package com.challenge.magneto.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IsHumanException.class})
    public final ResponseEntity handleForbidden() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @ExceptionHandler({InvalidDnaException.class})
    public final ResponseEntity handleBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
