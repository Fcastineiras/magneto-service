package com.challenge.magneto.service.mocks;


import java.util.ArrayList;

/**
 * Created by Fiamma on 5/5/2019.
 */
public class IsMutantListMocks {

    public static ArrayList<Boolean> getZeroBoth(){
        ArrayList<Boolean> Booleans= new ArrayList<>();
        return Booleans;
    }

    public static ArrayList<Boolean> getZeroHumans(){
        ArrayList<Boolean> Booleans= new ArrayList<>();
        addMutant(Booleans);
        addMutant(Booleans);
        return Booleans;
    }

    public static ArrayList<Boolean> getZeroMutants(){
        ArrayList<Boolean> Booleans= new ArrayList<>();
        addHuman(Booleans);
        addHuman(Booleans);
        return Booleans;
    }

    public static ArrayList<Boolean> getMoreMutants(){
        ArrayList<Boolean> Booleans= new ArrayList<>();
        addHuman(Booleans);
        addHuman(Booleans);
        addMutant(Booleans);
        addMutant(Booleans);
        addMutant(Booleans);
        addMutant(Booleans);
        return Booleans;
    }

    public static ArrayList<Boolean> getMoreHumans(){
        ArrayList<Boolean> Booleans= new ArrayList<>();
        addMutant(Booleans);
        addMutant(Booleans);
        addHuman(Booleans);
        addHuman(Booleans);
        addHuman(Booleans);
        addHuman(Booleans);
        addHuman(Booleans);
        addHuman(Booleans);
        return Booleans;
    }

    private static void addMutant(ArrayList<Boolean> list){
        list.add(new Boolean(true));
    }

    private static void addHuman(ArrayList<Boolean> list){
        list.add(new Boolean( false));
    }

}
