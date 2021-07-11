package com.geekseat.witch.saga.util;


import org.springframework.stereotype.Component;

/**
 * The Class VillagerHelper
 *
 * @author rafi.saeful.rahman
 */
@Component
public class VillagerHelper {

    public int getPeopleKilledOnYear(int year) {
        int[] villagers = new int[year + 2];
        for (int i = 2; i < year + 2; i++) {
            villagers[i] = villagers[i - 2] + villagers[i - 1] + 1;
        }
        return villagers[year + 1];
    }

    public double averageKilledPeople(int Aaod, int Ayod, int Baod, int Byod) {
        double personA = getPeopleKilledOnYear(Ayod - Aaod);
        double personB = getPeopleKilledOnYear(Byod - Baod);
        if (personA <= 0 || personB <= 0) {
            return -1;
        }
        return (personA + personB) / 2;
    }
}
