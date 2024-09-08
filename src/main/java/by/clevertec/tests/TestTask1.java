package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TestTask1 {

    public static final String FEMALE = "Female";

    @Test
    public void testSuccess() {

        List<Animal> testAnimals = Arrays.asList(
                new Animal(614, "Snake, buttermilk", 10, "Belarusian", "Bigender"),
                new Animal(649, "European stork", 10, "Danish", FEMALE),
                new Animal(712, "Flamingo, chilean", 10, "Somali", "Male"),
                new Animal(713, "Red-breasted cockatoo", 10, "Papiamento", FEMALE),
                new Animal(744, "Blue-tongued lizard", 10, "Swati", "Male"),
                new Animal(775, "Wolf spider", 10, "Romanian", FEMALE),
                new Animal(857, "Jackal, silver-backed", 10, "Kazakh", FEMALE)
        );

        List<Animal> animals = Util.getAnimals();
        List<Animal> myZoo = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> IntStream.range(0, list.size())
                                .filter(i -> i / 7 == 2)
                                .mapToObj(list::get)
                                .toList()
                ));


        String resultOutput = testAnimals.stream().map(Animal::toString).collect(Collectors.joining("\n"));
        String expectedOutput = myZoo.stream().map(Animal::toString).collect(Collectors.joining("\n"));

        assertEquals(expectedOutput, resultOutput);
    }

    @Test
    public void testFailure() {
        List<Animal> testAnimals = Arrays.asList(
                new Animal(614, "Snake, buttermilk", 10, "Belarusian", "Bigender")
        );
        List<Animal> animals = Util.getAnimals();
        List<Animal> myZoo = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> IntStream.range(0, list.size())
                                .filter(i -> i / 7 == 2)
                                .mapToObj(list::get)
                                .toList()
                ));


        String resultOutput = testAnimals.stream().map(Animal::toString).collect(Collectors.joining("\n"));
        String expectedOutput = myZoo.stream().map(Animal::toString).collect(Collectors.joining("\n"));
        assertNotEquals(resultOutput, expectedOutput);
    }
}