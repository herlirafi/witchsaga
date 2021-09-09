package com.geekseat.witch.saga.util;


import org.springframework.stereotype.Component;

@Component
public class VillagerHelper {

    public int getPeopleKilledOnYear(int year) {
        int a = 0, b = 1, k, y = 1;
        for (int i = 2; i <= year; i++) {
            k = a + b;
            a = b;
            b = k;
            y = y + b;
        }
        return y;
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
