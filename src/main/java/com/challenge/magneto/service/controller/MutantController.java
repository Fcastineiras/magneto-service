package com.challenge.magneto.service.controller;

import com.challenge.magneto.service.exception.IsHumanException;
import com.challenge.magneto.service.model.Dna;
import com.challenge.magneto.service.model.dto.DnaDto;
import com.challenge.magneto.service.service.MutantService;
import com.challenge.magneto.service.util.DnaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Fiamma on 2/5/2019.
 */
@Controller
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @PostMapping(path = "/mutant")
    public ResponseEntity isMutant(@RequestBody DnaDto dnaDto) {
        DnaValidator.isValid(dnaDto);
        Dna dna = mutantService.isMutant(dnaDto.getDna());
        if (!dna.isMutant()){
            throw new IsHumanException();
        }
        return ResponseEntity.ok().build();
    }
}
