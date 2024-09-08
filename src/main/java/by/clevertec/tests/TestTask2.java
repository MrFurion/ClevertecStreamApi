package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask2 {
    @Test
    public void testSuccess() {

        List<String> animalBreeds = Arrays.asList(
                "HURON",
                "Lorikeet, scaly-breasted",
                "BOA, MALAGASY GROUND",
                "BRAZILIAN TAPIR",
                "JAEGER, LONG-TAILED",
                "Mourning collared dove",
                "BLUE AND YELLOW MACAW",
                "GULL, LAVA",
                "GOLIATH HERON",
                "TORTOISE, INDIAN STAR",
                "SOUTH AMERICAN PUMA",
                "LONG-FINNED PILOT WHALE",
                "Penguin, galapagos",
                "Woodpecker, red-headed",
                "Mexican beaded lizard",
                "Common dolphin",
                "GULL, LAVA"
        );

        List<Animal> animals = Util.getAnimals();

        List<String> actualJapaneseAnimalBreeds = animals.stream()
                .filter(animal -> "Japanese".equals(animal.getOrigin()))
                .map(animal -> {
                    if ("Female".equals(animal.getGender())) {
                        return animal.getBread().toUpperCase();
                    }
                    return animal.getBread();
                })
                .toList();

        assertEquals(animalBreeds, actualJapaneseAnimalBreeds);
    }

    @Test
    public void testFailure() {
        List<String> animalBreeds = Arrays.asList(
                "Empty"
        );

        List<Animal> animals = Util.getAnimals();

        List<String> actualJapaneseAnimalBreeds = animals.stream()
                .filter(animal -> "Japanese".equals(animal.getOrigin()))
                .map(animal -> {
                    if ("Female".equals(animal.getGender())) {
                        return animal.getBread().toUpperCase();
                    }
                    return animal.getBread();
                })
                .toList();

        assertNotEquals(animalBreeds, actualJapaneseAnimalBreeds);
    }
}
