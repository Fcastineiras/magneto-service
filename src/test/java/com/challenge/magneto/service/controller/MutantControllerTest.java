package com.challenge.magneto.service.controller;

import com.challenge.magneto.service.exception.IsHumanException;
import com.challenge.magneto.service.mocks.DnaDtoMocks;
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
public class MutantControllerTest {

    @Autowired
    private MutantController mutantController;

    @Test(expected = IsHumanException.class)
    public void isHumanDnaException() {
        ResponseEntity responseEntity = mutantController.isMutant(DnaDtoMocks.getHumanDna());
        assertEquals(responseEntity.getStatusCodeValue(), 403);
    }
    @Test
    public void isMutantDna() {
        ResponseEntity responseEntity = mutantController.isMutant(DnaDtoMocks.getValidDna());
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }
}
