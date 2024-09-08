package by.clevertec.tests;

import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask13 {

    public static final String HOSPITAL = "Hospital";

    @Test
    public void testSuccess() {
        List<House> houses = Util.getHouses();
        LocalDate today = LocalDate.now();

        List<AbstractMap.SimpleEntry<String, Person>> listPerson = houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                        .map(person -> new AbstractMap.SimpleEntry<>(house.getBuildingType(), person)))
                .sorted(Comparator.comparing((AbstractMap.SimpleEntry<String, Person> entry) -> HOSPITAL.equals(entry.getKey()) ? 0 : 1)
                        .thenComparing(entry -> {
                            if (HOSPITAL.equals(entry.getKey())) {
                                return 0;
                            }
                            LocalDate birthDate = entry.getValue().getDateOfBirth();
                            int age = Period.between(birthDate, today).getYears();
                            return age < 18 ? 0 : age > 62 ? 1 : 2;
                        }))
                .limit(500)
                .toList();
        int count = listPerson.size();
        assertEquals(count, 500);
    }

    @Test
    public void testFailure() {
        List<House> houses = Util.getHouses();
        LocalDate today = LocalDate.now();

        List<AbstractMap.SimpleEntry<String, Person>> listPerson = houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                        .map(person -> new AbstractMap.SimpleEntry<>(house.getBuildingType(), person)))
                .sorted(Comparator.comparing((AbstractMap.SimpleEntry<String, Person> entry) -> HOSPITAL.equals(entry.getKey()) ? 0 : 1)
                        .thenComparing(entry -> {
                            if (HOSPITAL.equals(entry.getKey())) {
                                return 0;
                            }
                            LocalDate birthDate = entry.getValue().getDateOfBirth();
                            int age = Period.between(birthDate, today).getYears();
                            return age < 18 ? 0 : age > 62 ? 1 : 2;
                        }))
                .limit(500)
                .toList();
        int count = listPerson.size();
        assertNotEquals(count, 501);
    }
}
