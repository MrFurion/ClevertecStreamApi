package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask6 {
    @Test
    public void testSuccess() {
        List<Animal> animals = Util.getAnimals();
        boolean aBoolean = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female"));
        assertFalse(aBoolean);
    }

    @Test
    public void testFailure() {
        List<Animal> animals = Util.getAnimals();
        boolean aBoolean = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female"));
        assertNotEquals(aBoolean, true);
    }
}
