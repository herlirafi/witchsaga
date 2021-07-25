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
        int A = Ayod - Aaod;
        int B = Byod - Baod;
        if (A <= 0 || B <= 0) {
            return -1;
        }
        double personA = getPeopleKilledOnYear(A);
        double personB = getPeopleKilledOnYear(B);
        return (personA + personB) / 2;
    }
}
