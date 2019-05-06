package com.challenge.magneto.service.transformer;

import com.challenge.magneto.service.model.StatsDto;
import java.util.ArrayList;

/**
 * Created by Fiamma on 5/5/2019.
 */
public class StatsTransformer {

    public static StatsDto statsByDnaList(ArrayList<Boolean> isMutantCollection){
        Long totalValues = isMutantCollection.stream().filter(i -> i != null).count();
        Long mutantsCount = isMutantCollection.stream().filter(i -> i != null).filter(j -> j).count();
        Long humansCount = totalValues - mutantsCount;
        Double ratio = getRatio(mutantsCount.doubleValue(), humansCount.doubleValue());

        return new StatsDto(mutantsCount, humansCount, ratio);
    }

    private static Double getRatio(double mutantsCount, double humansCount){
        Double ratio;
        if ((humansCount == 0 && mutantsCount == 0) || mutantsCount == 0) {
            ratio = 0.0;
        }else if(humansCount == 0){
            return mutantsCount;
        }else{
            ratio = mutantsCount / humansCount;
        }
        return (double)Math.round(ratio * 100d) / 100d;
    }
}
