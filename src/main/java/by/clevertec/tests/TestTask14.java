package by.clevertec.tests;

import by.clevertec.model.Car;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask14 {
    public static final String DISCARDED = "Discarded";
    private static Map<String, Double> standardCar;

    public static final String MONGOLIA = "Mongolia";

    public static final String UZBEKISTAN = "Uzbekistan";

    public static final String KAZAKHSTAN = "Kazakhstan";

    public static final String TURKMENISTAN = "Turkmenistan";

    public static final String KYRGYZSTAN = "Kyrgyzstan";

    public static final String RUSSIA = "Russia";

    static {
        standardCar = new HashMap<>();
        standardCar.put(MONGOLIA, 120.80879999999999);
        standardCar.put(UZBEKISTAN, 107.6355);
        standardCar.put(KAZAKHSTAN, 2023.7544599999999);
        standardCar.put(TURKMENISTAN, 221.91834);
        standardCar.put(KYRGYZSTAN, 531.2945399999999);
        standardCar.put(RUSSIA, 14990.165819999998);
    }

    @Test
    public void testSuccess() {
        List<Car> cars = Util.getCars();

        Map<String, Double> transportationCosts = cars.stream()
                .collect(Collectors.groupingBy(car -> {
                    if ("Jaguar".equals(car.getCarMake()) || "White".equals(car.getColor())) {
                        return TURKMENISTAN;
                    } else if (car.getMass() < 1500 && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())) {
                        return UZBEKISTAN;
                    } else if ("Black".equals(car.getColor()) && car.getMass() > 4000 ||
                            List.of("GMC", "Dodge").contains(car.getCarMake())) {
                        return KAZAKHSTAN;
                    } else if (car.getReleaseYear() < 1982 || List.of("Civic", "Cherokee").contains(car.getCarModel())) {
                        return KYRGYZSTAN;
                    } else if (!List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor()) || car.getPrice() > 40000) {
                        return RUSSIA;
                    } else if (car.getVin().contains("59")) {
                        return MONGOLIA;
                    } else {
                        return DISCARDED;
                    }
                }, Collectors.summingInt(Car::getMass)))
                .entrySet().stream()
                .filter(entry -> !DISCARDED.equals(entry.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * 7.14 / 1000
                ));
        assertEquals(transportationCosts, standardCar);

    }

    @Test
    public void testFailure() {
        List<Car> cars = Util.getCars();

        Map<String, Double> transportationCosts = cars.stream()
                .collect(Collectors.groupingBy(car -> {
                    if ("Jaguar".equals(car.getCarMake()) || "White".equals(car.getColor())) {
                        return TURKMENISTAN;
                    } else if (car.getMass() < 1500 && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())) {
                        return UZBEKISTAN;
                    } else if ("Black".equals(car.getColor()) && car.getMass() > 4000 ||
                            List.of("GMC", "Dodge").contains(car.getCarMake())) {
                        return KAZAKHSTAN;
                    } else if (car.getReleaseYear() < 1982 || List.of("Civic", "Cherokee").contains(car.getCarModel())) {
                        return KYRGYZSTAN;
                    } else if (!List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor()) || car.getPrice() > 40000) {
                        return RUSSIA;
                    } else if (car.getVin().contains("59")) {
                        return MONGOLIA;
                    } else {
                        return DISCARDED;
                    }
                }, Collectors.summingInt(Car::getMass)))
                .entrySet().stream()
                .filter(entry -> !DISCARDED.equals(entry.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * 7.14 / 1000
                ));
        transportationCosts.put("Antlantida", 1000000.99);
        assertNotEquals(transportationCosts, standardCar);
    }
}
