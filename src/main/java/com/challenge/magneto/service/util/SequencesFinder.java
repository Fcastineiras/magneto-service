package com.challenge.magneto.service.util;

/**
 * Created by Fiamma on 4/5/2019.
 */
public class SequencesFinder {

    private char[][] dna;
    private int dnaSize;
    private int sequencesRequired;
    private int sameCharRequired;
    private int sequencesFoundCount = 0;

    public SequencesFinder(char[][] dna, int sequencesRequired, int sameCharRequired) {
        this.dna = dna;
        this.dnaSize = dna.length;
        this.sequencesRequired = sequencesRequired;
        this.sameCharRequired = sameCharRequired;
    }

    public boolean isSequencesRequiredFound() {
        if (dnaSize < sameCharRequired){
            return false;
        }
        int function = 1;
        while (function > 0){
            function = functionSelected(function);
            if (sequencesFoundCount >= sequencesRequired){
                return true;
            }
        }
        return false;
    }

    private int functionSelected(int function){
        switch (function){
            case 1:
                reedHorizontal();
                break;
            case 2:
                reedVertical();
                break;
            case 3:
                reedDiagonalDownUp();
                break;
            case 4:
                reedDiagonalDownUp2();
                break;
            case 5:
                reedDiagonalUpDown();
                break;
            case 6:
                reedDiagonalUpDown2();
                break;
            default:
                return 0;
        }
        return function + 1;
    }

    private void reedHorizontal() {
        for (int i = 0; i < dnaSize; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - 1; j++) {
                sameCharCount = validMatch(i,0,j,1,sameCharCount);
            }
        }
    }

    private void reedVertical() {
        for (int i = 0; i < dnaSize ; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - 1; j++) {
                sameCharCount = validMatch(j,1,i,0,sameCharCount);
            }
        }
    }

    private void reedDiagonalUpDown() {
        for (int i = 0; i + 3 < dnaSize; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - i - 1; j++) {
                sameCharCount = validMatch(j + i, 1, j , 1, sameCharCount);
            }
        }
    }

    private void reedDiagonalUpDown2() {
        for (int i = 1; i < dnaSize; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - i - 1; j++) {
                sameCharCount = validMatch(j,1,j + i,1,sameCharCount);
            }
        }
    }

    private void reedDiagonalDownUp() {
        for (int i = 3; i < dnaSize; i++) {
            int sameCharCount = 1;
            for (int j = 0; j <= i - 1; j++) {
                sameCharCount = validMatch(i - j,-1,j,1,sameCharCount);
            }
        }
    }

    private void reedDiagonalDownUp2() {
        for (int i = 0; i < dnaSize - 4; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - i - 1 - 1; j++) {
                sameCharCount = validMatch(dnaSize - j - 1,0,j + i + 1,1,sameCharCount);
            }
        }
    }

    private int validMatch(int line, int variantLine, int column, int variantColumn, int sameCharCount) {
        if (dna[line][column] == dna[line + variantLine][column + variantColumn]) {
            sameCharCount++;
            if (sameCharCount >= sameCharRequired){
                sameCharCount = 1;
                sequencesFoundCount++;
            }
        } else {
            sameCharCount = 1;
        }
        return sameCharCount;
    }
}
