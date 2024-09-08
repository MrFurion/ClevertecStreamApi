package by.clevertec.util;

import java.util.Map;

import static java.lang.System.out;

public class CarCalculator {
    public static void printTransportCosts(Map<String, Double> transportationCosts) {
        transportationCosts.forEach((country, cost) -> {
            double totalMass = cost * 1000 / 7.14;
            out.println("Country: " + country + ", Total Mass: " + totalMass + " kg, Transportation Cost: $" + Math.round(cost));
        });

        double totalRevenue = transportationCosts.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        out.println("Total Revenue: $" + totalRevenue);
    }

}
