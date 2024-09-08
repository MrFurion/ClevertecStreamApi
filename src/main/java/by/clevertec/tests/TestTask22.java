package by.clevertec.tests;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask22 {
    @Test
    public void testSuccess() {
        List<Student> students = Util.getStudents();
        Map<String, Integer> minAge = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Student::getAge)),
                                optional -> optional.map(Student::getAge).orElse(null)
                        )
                ));
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String s : Arrays.asList("ComputerScience", "Chemistry", "Mathematics", "Physics")) {
            stringIntegerMap.put(s, 18);
        }
        assertEquals(minAge, stringIntegerMap);
    }

    @Test
    public void testFailure() {
        List<Student> students = Util.getStudents();
        Map<String, Integer> minAge = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Student::getAge)),
                                optional -> optional.map(Student::getAge).orElse(null)
                        )
                ));
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String s : Arrays.asList("Chemistry", "Mathematics", "Physics")) {
            stringIntegerMap.put(s, 18);
        }
        assertNotEquals(minAge, stringIntegerMap);
    }
}
