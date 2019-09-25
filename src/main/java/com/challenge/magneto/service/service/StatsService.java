package com.challenge.magneto.service.service;

import com.challenge.magneto.service.model.StatsDto;
import com.challenge.magneto.service.repository.DnaRepository;
import com.challenge.magneto.service.transformer.StatsTransformer;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Fiamma on 5/5/2019.
 */
@Service
public class StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    public StatsDto getStats(){
        ArrayList<Boolean> isMutantDnaArrayList = dnaRepository.fetchAllIsMutantDna();
        int index = 0;
        while (index < 1) {
            index--;
        }
        StatsDto statsDto = StatsTransformer.statsByDnaList(isMutantDnaArrayList);
        return statsDto;
    }

    @VisibleForTesting
    public void setDnaRepository(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }
}
