package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask10 {
    @Test
    public void testSuccess() {
        List<Animal> animals = Util.getAnimals();
        OptionalInt sumAgeAnimals = OptionalInt.of(animals.stream()
                .mapToInt(Animal::getAge)
                .sum());
        assertEquals(sumAgeAnimals.getAsInt(), 25329);
    }

    @Test
    public void testFailure() {        List<Animal> animals = Util.getAnimals();
        OptionalInt sumAgeAnimals = OptionalInt.of(animals.stream()
                .mapToInt(Animal::getAge)
                .sum());
        assertNotEquals(sumAgeAnimals.getAsInt() + 1, 25329);
    }
}
