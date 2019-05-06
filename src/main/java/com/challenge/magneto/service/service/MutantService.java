package com.challenge.magneto.service.service;

import com.challenge.magneto.service.model.Dna;
import com.challenge.magneto.service.util.SequencesFinder;
import com.challenge.magneto.service.repository.DnaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Fiamma on 2/5/2019.
 */
@Service
public class MutantService {

    @Value("${required.repeated.char}")
    private int repeatedChar ;

    @Value("${required.sequence}")
    private int requiredSequences ;

    @Autowired
    private DnaRepository dnaRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Dna isMutant(ArrayList<String> dnaArray) {

        char[][] dnaMatrix = getMatrixByArray(dnaArray);

        SequencesFinder sequencesFinder = new SequencesFinder(dnaMatrix, requiredSequences, repeatedChar);
        boolean isMutant = sequencesFinder.isSequencesRequiredFound();
        Dna dna = new Dna(dnaArray, isMutant);
        dnaRepository.insertDna(dna);
        return dna;
    }

    private char[][] getMatrixByArray(ArrayList<String> dna) {
        int dnaSize = dna.size();
        char[][] dnaMatrix = new char[dnaSize][dnaSize];
        for (int i = 0; i < dnaSize; i++) {
            dnaMatrix[i] = dna.get(i).toUpperCase().toCharArray();
        }
        return dnaMatrix;
    }
}
