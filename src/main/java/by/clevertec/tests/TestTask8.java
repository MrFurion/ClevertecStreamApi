package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask8 {
    @Test
    public void testSuccess() {
        List<Animal> animals = Util.getAnimals();
        Optional<Animal> animal = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge));
        assertEquals(48, animal.get().getAge());
    }

    @Test
    public void testFailure() {
        List<Animal> animals = Util.getAnimals();
        Optional<Animal> animal = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge));
        assertNotEquals(0, animal.get().getAge());
    }
}
