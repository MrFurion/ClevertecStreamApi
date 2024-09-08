package by.clevertec.tests;

import by.clevertec.model.Flower;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask15 {
    @Test
    public void testSuccess() {
        List<Flower> flowers = Util.getFlowers();
        double waterCostPerCubicMeter = 1.39;
        double totalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin, Comparator.reverseOrder())
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay, Comparator.reverseOrder()))
                .filter(flower -> flower.getCommonName().toUpperCase().compareTo("S") >= 0 ||
                        flower.getCommonName().toUpperCase().compareTo("C") <= 0)
                .filter(flower -> flower.isShadePreferred() || List.of("Glass", "Aluminium", "Steel").containsAll(flower.getFlowerVaseMaterial()))
                .map(flower -> {
                    double waterCost = flower.getWaterConsumptionPerDay() * 5 * 365 * waterCostPerCubicMeter;
                    return flower.getPrice() + waterCost;
                })
                .reduce(0.0, Double::sum);
        assertEquals(totalCost, 2136211.712499999);
    }

    @Test
    public void testFailure() {
        List<Flower> flowers = Util.getFlowers();
        double waterCostPerCubicMeter = 1.39;
        double totalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin, Comparator.reverseOrder())
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay, Comparator.reverseOrder()))
                .filter(flower -> flower.getCommonName().toUpperCase().compareTo("S") >= 0 ||
                        flower.getCommonName().toUpperCase().compareTo("C") <= 0)
                .filter(flower -> flower.isShadePreferred() || List.of("Glass", "Aluminium", "Steel").containsAll(flower.getFlowerVaseMaterial()))
                .map(flower -> {
                    double waterCost = flower.getWaterConsumptionPerDay() * 5 * 365 * waterCostPerCubicMeter;
                    return flower.getPrice() + waterCost;
                })
                .reduce(0.0, Double::sum);
        assertNotEquals(totalCost, 0.0);
    }
}
