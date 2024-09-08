package by.clevertec.tests;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask3 {

    public static final String ASSAMESE = "Assamese";
    public static final String AYMARA = "Aymara";
    public static final String FEMALE = "Female";
    public static final String ALBANIAN = "Albanian";
    public static final String AZERI = "Azeri";
    public static final String AFRIKAANS = "Afrikaans";
    public static final String ARMENIAN = "Armenian";

    @Test
    public void testSuccess() {

        List<Animal> animalBreeds = Arrays.asList(
                new Animal(11, "House sparrow", 34, AZERI, "Male"),
                new Animal(21, "Barasingha deer", 34, AYMARA, "Genderfluid"),
                new Animal(45, "Dove, little brown", 43, AFRIKAANS, FEMALE),
                new Animal(70, "South American sea lion", 34, "Arabic", "Bigender"),
                new Animal(78, "Western palm tanager (unidentified)", 34, AFRIKAANS, FEMALE),
                new Animal(82, "Barbet, black-collared", 41, AZERI, "Male"),
                new Animal(110, "Eastern grey kangaroo", 33, "Arabic", FEMALE),
                new Animal(111, "Gray duiker", 39, AYMARA, "Male"),
                new Animal(127, "Pied avocet", 37, ARMENIAN, "Male"),
                new Animal(129, "Bear, black", 42, AYMARA, FEMALE),
                new Animal(131, "Fox, crab-eating", 34, "Amharic", FEMALE),
                new Animal(180, "Chital", 38, ASSAMESE, FEMALE),
                new Animal(189, "American racer", 47, ARMENIAN, FEMALE),
                new Animal(194, "Cat, jungle", 42, ALBANIAN, "Male"),
                new Animal(215, "Woodchuck", 49, AYMARA, FEMALE),
                new Animal(220, "Macaque, pig-tailed", 47, AYMARA, FEMALE),
                new Animal(247, "Springbuck", 50, AFRIKAANS, "Agender"),
                new Animal(253, "Hottentot teal", 36, ALBANIAN, FEMALE),
                new Animal(270, "Yellow-brown sungazer", 45, AFRIKAANS, "Male"),
                new Animal(278, "Seal, common", 32, ALBANIAN, "Male"),
                new Animal(290, "Anteater, giant", 33, ARMENIAN, "Male"),
                new Animal(383, "Fox, crab-eating", 35, ARMENIAN, "Male"),
                new Animal(413, "Chimpanzee", 46, AYMARA, "Genderqueer"),
                new Animal(429, "Jackrabbit, white-tailed", 42, AYMARA, FEMALE),
                new Animal(474, "Dama wallaby", 37, AFRIKAANS, "Male"),
                new Animal(500, "Viper, egyptian", 46, ASSAMESE, FEMALE),
                new Animal(558, "Long-tailed skua", 38, ALBANIAN, "Male"),
                new Animal(597, "Richardson's ground squirrel", 38, ASSAMESE, FEMALE),
                new Animal(598, "Spurfowl, yellow-necked", 31, ASSAMESE, "Male"),
                new Animal(648, "Common dolphin", 32, ALBANIAN, "Male"),
                new Animal(691, "Tiger snake", 34, ASSAMESE, FEMALE),
                new Animal(742, "Mallard", 40, AZERI, "Male"),
                new Animal(751, "Ornate rock dragon", 41, AZERI, "Male"),
                new Animal(795, "Mongoose, eastern dwarf", 37, AFRIKAANS, FEMALE),
                new Animal(814, "Gull, herring", 50, ASSAMESE, FEMALE),
                new Animal(836, "European stork", 35, ARMENIAN, FEMALE)
        );

        List<Animal> animals = Util.getAnimals();

        List<Animal> actualJapaneseAnimalBreeds = animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().startsWith("A"))
                .distinct()
                .peek(animal -> out.println(animal.getOrigin()))
                .toList();

        assertEquals(animalBreeds, actualJapaneseAnimalBreeds);
    }
    @Test
    public void testFailure() {
        List<Animal> animalBreeds = Arrays.asList(
                new Animal(11, "House sparrow", 34, AZERI, "Male")
        );

        List<Animal> animals = Util.getAnimals();

        List<Animal> actualJapaneseAnimalBreeds = animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().startsWith("A"))
                .distinct()
                .peek(animal -> out.println(animal.getOrigin()))
                .toList();

        assertNotEquals(animalBreeds, actualJapaneseAnimalBreeds);
    }
}
