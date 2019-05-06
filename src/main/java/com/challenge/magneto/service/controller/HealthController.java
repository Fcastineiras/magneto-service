package com.challenge.magneto.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class HealthController {

    @GetMapping(path = "/health")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().build();
    }

}