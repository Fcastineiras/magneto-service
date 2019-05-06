package com.challenge.magneto.service.model;

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
                recorrerHorizontal();
                break;
            case 2:
                recorrerVertical();
                break;
            case 3:
                recorrerDiagonalAbAr();
                break;
            case 4:
                recorrerDiagonalAbAr2();
                break;
            case 5:
                recorrerDiagonalArAb();
                break;
            case 6:
                recorrerDiagonalArAb2();
                break;
            default:
                return 0;
        }
        return function + 1;
    }

    private void recorrerDiagonalArAb() {
        for (int i = 0; i + 3 < dnaSize; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - i - 1; j++) {
                sameCharCount = validMatch(j + i, 1, j , 1, sameCharCount);
                System.out.println(dna[j + i][j]);
                System.out.println("consecutiva: " + dna[j + i + 1][j + 1]);
            }
            System.out.println("-------------------------------------");
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    private void recorrerDiagonalArAb2() {
        for (int i = 1; i < dnaSize; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - i - 1; j++) {
                sameCharCount = validMatch(j,1,j + i,1,sameCharCount);
                System.out.println(dna[j][j + i]);
                System.out.println("consecutiva: " + dna[j + 1][j + i + 1]);
            }
            System.out.println("-------------------------------------");
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    private void recorrerHorizontal() {
        for (int i = 0; i < dnaSize; i++) {
            int sameCharCount = 1;
            for (int j = 0; j < dnaSize - 1; j++) {
                sameCharCount = validMatch(i,0,j,1,sameCharCount);
                System.out.println(dna[i][j]);
                System.out.println("consecutiva: " + dna[i][j + 1]);
            }
            System.out.println("-------------------------------------");
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    private void recorrerVertical() {
        int sameCharCount = 1;
        System.out.println("RRREEEEEEVVVIIIIISSSAAAARRR");
        for (int i = 0; i < dnaSize ; i++) {
            for (int j = 0; j < dnaSize - 1; j++) {
                sameCharCount = validMatch(j,1,i,0,sameCharCount);

                System.out.println(dna[j][i]);
                System.out.println("consecutiva: " + dna[j + 1][i]);
            }
            System.out.println("-------------------------------------");
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    private void recorrerDiagonalAbAr() {
        int sameCharCount = 1;
        for (int i = 3; i < dnaSize; i++) {
            for (int j = 0; j <= i - 1; j++) {
                sameCharCount = validMatch(i - j,-1,j,1,sameCharCount);
                System.out.println(dna[i - j][j]);
                System.out.println("consecutiva: " + dna[i - j - 1][j + 1]);
            }
            System.out.println("-------------------------------------");
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    private void recorrerDiagonalAbAr2() {
        int sameCharCount = 1;
        for (int i = 0; i < dnaSize - 4; i++) {
            for (int j = 0; j < dnaSize - i - 1 - 1; j++) {
                sameCharCount = validMatch(dnaSize - j - 1,0,j + i + 1,1,sameCharCount);
                System.out.println(dna[dnaSize - j - 1][j + i + 1]);
                System.out.println("consecutiva: " + dna[dnaSize - j - 1][j + i + 2]);
            }
            System.out.println("-------------------------------------");
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
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
