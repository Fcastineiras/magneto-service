package com.challenge.magneto.service.controller;

import com.challenge.magneto.service.model.StatsDto;
import com.google.common.annotations.VisibleForTesting;
import com.challenge.magneto.service.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Fiamma on 5/5/2019.
 */
@Controller
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping(path = "/stats")
    public ResponseEntity getStats() {
        StatsDto statsDto = statsService.getStats();
        return ResponseEntity.ok(statsDto);
    }
}
