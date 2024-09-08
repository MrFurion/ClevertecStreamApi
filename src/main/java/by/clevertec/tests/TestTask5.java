package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask5 {
    @Test
    public void testSuccess() {
        List<Animal> animals = Util.getAnimals();
        boolean aBoolean= animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
        assertTrue(aBoolean);
    }
    @Test
    public void testFailure() {List<Animal> animals = Util.getAnimals();
        boolean aBoolean = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("null"));
        assertFalse(aBoolean);
    }
}
