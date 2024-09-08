package by.clevertec.tests;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask18 {
    @Test
    public void testSuccess() {
        List<Student> students = Util.getStudents();

        Map<String, Double> listAge = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)))
                .entrySet().stream()
                .sorted(Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        Map<String, Double> listStandard = new LinkedHashMap<>();
        listStandard.put("Chemistry", 19.416666666666668);
        listStandard.put("ComputerScience", 19.153846153846153);
        listStandard.put("Physics", 18.846153846153847);
        listStandard.put("Mathematics", 18.833333333333332);

        assertEquals(listAge, listStandard);
    }

    @Test
    public void testFailure() {
        List<Student> students = Util.getStudents();

        Map<String, Double> listAge = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)))
                .entrySet().stream()
                .sorted(Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        listAge.put("no", 0.0);

        Map<String, Double> listStandard = new LinkedHashMap<>();
        listStandard.put("Chemistry", 19.416666666666668);
        listStandard.put("ComputerScience", 19.153846153846153);
        listStandard.put("Physics", 18.846153846153847);
        listStandard.put("Mathematics", 18.833333333333332);

        assertNotEquals(listAge, listStandard);
    }
}
