package by.clevertec.tests;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask17 {
    @Test
    public void testSuccess() {
        List<Student> students = Util.getStudents();
        List<String> listGroup = students.stream()
                .map(Student::getGroup)
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
        List<String> listStandard = List.of("C-1", "C-2", "C-3", "C-4", "M-1", "M-2",
                "M-3", "P-1", "P-2", "P-3", "P-4");
        assertEquals(listGroup, listStandard);
    }

    @Test
    public void testFailure() {
        List<Student> students = Util.getStudents();
        List<String> listGroup = students.stream()
                .map(Student::getGroup)
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
        List<String> listStandard = List.of("C-1", "C-2", "C-3", "C-4", "M-1", "M-2",
                "M-3", "P-1", "P-2", "P-3");
        assertNotEquals(listGroup, listStandard);
    }
}
