package com.challenge.magneto.service.controller;

import com.challenge.magneto.service.mocks.IsMutantListMocks;
import com.challenge.magneto.service.model.StatsDto;
import com.challenge.magneto.service.repository.DnaRepository;
import com.challenge.magneto.service.service.StatsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Fiamma on 5/5/2019.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StatsControllerTest {

    @Autowired
    private StatsController statsController;

    @Autowired
    private StatsService statsService;

    @Mock
    private DnaRepository dnaRepository;

    @Test
    public void getStatsValues() {
        StatsDto statsDto =  new StatsDto(Long.valueOf(2),Long.valueOf(6),Double.valueOf(0.33));
        statsService.setDnaRepository(dnaRepository);
        Mockito.when(dnaRepository.fetchAllIsMutantDna()).thenReturn(IsMutantListMocks.getMoreHumans());

        ResponseEntity responseEntity = statsController.getStats();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        StatsDto statsResponse = (StatsDto) responseEntity.getBody();
        assertEquals(statsDto.getCount_human_dna(), statsResponse.getCount_human_dna());
        assertEquals(statsDto.getCount_mutant_dna(), statsResponse.getCount_mutant_dna());
        assertEquals(statsDto.getRatio(), statsResponse.getRatio());
    }

    @Test
    public void getStatsController() {
        ResponseEntity responseEntity = statsController.getStats();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }
}
