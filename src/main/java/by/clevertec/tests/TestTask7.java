package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask7 {
    @Test
    public void testSuccess() {
        List<Animal> animals = Util.getAnimals();
        boolean aBoolean= animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        assertTrue(aBoolean);
    }
    @Test
    public void testFailure() {List<Animal> animals = Util.getAnimals();
        boolean aBoolean = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        assertNotEquals(aBoolean, false);
    }
}
