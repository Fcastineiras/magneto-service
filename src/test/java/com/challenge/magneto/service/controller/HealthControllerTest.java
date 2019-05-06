package com.challenge.magneto.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
/**
 * Created by Fiamma on 5/5/2019.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HealthControllerTest {

    @Autowired
    private HealthController healthController;

    @Test
    public void healthCheck() {
        ResponseEntity responseEntity = healthController.health();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }
}
