package com.challenge.magneto.service.model;

import com.challenge.magneto.service.model.dto.Data;

import java.util.ArrayList;

/**
 * Created by Fiamma on 1/5/2019.
 */
public class Dna implements Data {

    private ArrayList<String> dna = new ArrayList<>();
    private boolean isMutant;

    public Dna(ArrayList<String> dna, boolean isMutant){
        this.dna = dna;
        this.isMutant = isMutant;
    }

    public ArrayList<String> getDna(){ return dna;}
    public boolean isMutant() { return isMutant; }

}
