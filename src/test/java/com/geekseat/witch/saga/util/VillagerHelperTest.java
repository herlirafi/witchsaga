package com.geekseat.witch.saga.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VillagerHelperTest {

    private final VillagerHelper villagerHelper = new VillagerHelper();

    @Test
    void testGetPeopleKilledOnYearSuccess() {
        int result = villagerHelper.getPeopleKilledOnYear(5);
        assertEquals(12, result);
    }

    @Test
    void testGetPeopleKilledOnYearFailed() {
        assertThrows(NegativeArraySizeException.class, () -> villagerHelper.getPeopleKilledOnYear(-5));
    }

    @Test
    void testAverageKilledPeopleSuccess() {
        double result = villagerHelper.averageKilledPeople(10, 12, 13, 17);
        assertEquals(4.5, result);
    }

    @Test
    void testAverageKilledPeopleFailed() {
        double result = villagerHelper.averageKilledPeople(0, -9, 0, 0);
        assertEquals(-1, result);
    }
}
