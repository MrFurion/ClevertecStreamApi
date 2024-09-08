package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask4 {
    @Test
    public void testSuccess() {
        List<Animal> animals = Util.getAnimals();
        int count = (int) animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        assertEquals(count, 476);
    }
    @Test
    public void testFailure() {
        List<Animal> animals = Util.getAnimals();
        int count = (int) animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        assertNotEquals(count, 0);
    }
}
