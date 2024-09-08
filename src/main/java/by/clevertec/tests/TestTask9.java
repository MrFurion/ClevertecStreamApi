package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask9 {
    @Test
    public void testSuccess() {
        List<Animal> animals = Util.getAnimals();
        OptionalInt minLength = animals.stream()
                .map(animal -> animal.getBread().toCharArray())
                .mapToInt(charArray -> charArray.length)
                .min();
        if (minLength.isPresent()) {
            int minAssert = minLength.getAsInt();
            assertEquals(minAssert, 3);
        }
    }

    @Test
    public void testFailure() {
        List<Animal> animals = Util.getAnimals();
        OptionalInt minLength = animals.stream()
                .map(animal -> animal.getBread().toCharArray())
                .mapToInt(charArray -> charArray.length)
                .min();
        if (minLength.isPresent()){
            int minAssert = minLength.getAsInt();
            assertNotEquals(minAssert, 0);
        }
    }
}
