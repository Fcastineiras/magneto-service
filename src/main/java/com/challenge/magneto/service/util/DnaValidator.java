package com.challenge.magneto.service.util;

import com.challenge.magneto.service.exception.InvalidDnaException;
import com.challenge.magneto.service.model.dto.DnaDto;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Fiamma on 1/5/2019.
 */
public class DnaValidator {
    public static void isValid(DnaDto dnaDto) {
        ArrayList<String> dna = dnaDto.getDna();
        int rows = dna.size();
        Pattern pattern = Pattern.compile("[atgc]+", Pattern.CASE_INSENSITIVE);
        dna.stream().forEach( row ->{
            if(row.length() != rows || !pattern.matcher(row).matches()){
            throw new InvalidDnaException();
            }});
    }
}
