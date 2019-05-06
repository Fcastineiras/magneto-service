package com.challenge.magneto.service.mocks;

import com.challenge.magneto.service.model.dto.DnaDto;

import java.util.ArrayList;

/**
 * Created by Fiamma on 2/5/2019.
 */
public class DnaDtoMocks {

     public static DnaDto getValidDna(){
        ArrayList<String> validDna = new ArrayList<String>();
        validDna.add("ACCGT");
        validDna.add("ACCGT");
        validDna.add("ACCGT");
        validDna.add("ACCGT");
        validDna.add("ACCGT");
        return new DnaDto(validDna);
    }

    public static DnaDto getInvalidCharDna(){
        ArrayList<String> invalidDna = new ArrayList<String>();
        invalidDna.add("ACCSL");
        invalidDna.add("ACCGT");
        invalidDna.add("AKJGT");
        invalidDna.add("ACCGT");
        return new DnaDto(invalidDna);
    }

    public static DnaDto getInvalidFormatDna(){
        ArrayList<String> invalidDna = new ArrayList<String>();
        invalidDna.add("ACCGT");
        invalidDna.add("ACCGT");
        invalidDna.add("ACCGT");
        return new DnaDto(invalidDna);
    }

    public static DnaDto getHumanDna(){
        ArrayList<String> validDna = new ArrayList<String>();
        validDna.add("CCAAC");
        validDna.add("GGCCG");
        validDna.add("TTAAT");
        validDna.add("GGCCG");
        validDna.add("AATTA");
        return new DnaDto(validDna);
    }

    public static DnaDto getSmallHumanDna(){
        ArrayList<String> validDna = new ArrayList<>();
        validDna.add("CCA");
        validDna.add("GGC");
        validDna.add("TTA");
        return new DnaDto(validDna);
    }

    public static DnaDto getHumanWithOneSequenceDna(){
        ArrayList<String> validDna = new ArrayList<String>();
        validDna.add("CCAAC");
        validDna.add("CCAAC");
        validDna.add("TGTGT");
        validDna.add("TGTGT");
        validDna.add("ACCCC");
        return new DnaDto(validDna);
    }

    public static DnaDto getMutantDna(){
        ArrayList<String> validDna = new ArrayList<String>();
        validDna.add("CCAAC");
        validDna.add("CCAAC");
        validDna.add("TGCGT");
        validDna.add("TGTCT");
        validDna.add("AGGGG");
        return new DnaDto(validDna);
    }
}
