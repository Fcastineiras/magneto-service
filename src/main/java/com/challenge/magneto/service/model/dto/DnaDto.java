package com.challenge.magneto.service.model.dto;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Fiamma on 1/5/2019.
 */
public class DnaDto implements Data {
    private ArrayList<String> dna = new ArrayList<>();
    public DnaDto(){}

    public DnaDto(ArrayList<String> dna) {
        this.dna = dna;
    }

    public ArrayList<String> getDna() { return dna; }
}

