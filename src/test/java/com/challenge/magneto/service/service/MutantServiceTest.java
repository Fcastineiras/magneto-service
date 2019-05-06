package com.challenge.magneto.service.service;

import com.challenge.magneto.service.mocks.DnaDtoMocks;
import com.challenge.magneto.service.model.Dna;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fiamma on 2/5/2019.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MutantServiceTest {

    @Autowired
    private MutantService mutantService;

    @Test
    public void isHumanDna() {
        Dna dna = mutantService.isMutant(DnaDtoMocks.getHumanDna().getDna());
        assertEquals(dna.isMutant(), false);
    }

    @Test
    public void isSmallHumanDna() {
        Dna dna = mutantService.isMutant(DnaDtoMocks.getSmallHumanDna().getDna());
        assertEquals(dna.isMutant(), false);
    }

    @Test
    public void isHumanWithOneSequenceDna() {
        Dna dna = mutantService.isMutant(DnaDtoMocks.getHumanWithOneSequenceDna().getDna());
        assertEquals(dna.isMutant(), false);
    }

    @Test
    public void isMutantDna() {
        Dna dna = mutantService.isMutant(DnaDtoMocks.getValidDna().getDna());
        assertEquals(dna.isMutant(), true);

    }
}
