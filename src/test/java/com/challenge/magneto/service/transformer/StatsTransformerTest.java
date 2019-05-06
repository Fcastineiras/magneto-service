package com.challenge.magneto.service.transformer;

import com.challenge.magneto.service.mocks.IsMutantListMocks;
import com.challenge.magneto.service.model.StatsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fiamma on 5/5/2019.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StatsTransformerTest {

    @Test
    public void zeroBothTest() {
        StatsDto statsDto = StatsTransformer.statsByDnaList(IsMutantListMocks.getZeroBoth());
        assertEquals(statsDto.getCount_human_dna().intValue(), 0);
        assertEquals(statsDto.getCount_mutant_dna().intValue(), 0);
        assertEquals(statsDto.getRatio(), Double.valueOf(0));
    }

    @Test
    public void zeroHumansTest() {
        StatsDto statsDto = StatsTransformer.statsByDnaList(IsMutantListMocks.getZeroHumans());
        assertEquals(statsDto.getCount_human_dna().intValue(), 0);
        assertEquals(statsDto.getCount_mutant_dna().intValue(), 2);
        assertEquals(statsDto.getRatio(), Double.valueOf( statsDto.getCount_mutant_dna()));
    }

    @Test
    public void zeroMutantsTest() {
        StatsDto statsDto = StatsTransformer.statsByDnaList(IsMutantListMocks.getZeroMutants());
        assertEquals(statsDto.getCount_human_dna().intValue(), 2);
        assertEquals(statsDto.getCount_mutant_dna().intValue(), 0);
        assertEquals(statsDto.getRatio(), Double.valueOf(0));
    }

    @Test
    public void moreMutantsTest() {
        StatsDto statsDto = StatsTransformer.statsByDnaList(IsMutantListMocks.getMoreMutants());
        assertEquals(statsDto.getCount_human_dna().intValue(), 2);
        assertEquals(statsDto.getCount_mutant_dna().intValue(), 4);
        assertEquals(statsDto.getRatio(), Double.valueOf(2));
    }

    @Test
    public void moreHumansTest() {
        StatsDto statsDto = StatsTransformer.statsByDnaList(IsMutantListMocks.getMoreHumans());
        assertEquals(statsDto.getCount_human_dna().intValue(), 6);
        assertEquals(statsDto.getCount_mutant_dna().intValue(), 2);
        assertEquals(statsDto.getRatio(), Double.valueOf(0.33));
    }

}
