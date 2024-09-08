package by.clevertec.tests;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask21 {
    private static Map<String, Long> groupCountStandard;

    static {
        groupCountStandard = new HashMap<>();
        groupCountStandard.put("M-1", 5L);
        groupCountStandard.put("M-2", 4L);
        groupCountStandard.put("M-3", 3L);
        groupCountStandard.put("P-1", 7L);
        groupCountStandard.put("P-2", 2L);
        groupCountStandard.put("P-3", 3L);
        groupCountStandard.put("P-4", 1L);
        groupCountStandard.put("C-1", 4L);
        groupCountStandard.put("C-2", 11L);
        groupCountStandard.put("C-3", 9L);
        groupCountStandard.put("C-4", 1L);
    }

    @Test
    public void testSuccess() {
        List<Student> students = Util.getStudents();
        Map<String, Long> groupCount = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.counting()
                ));
        assertEquals(groupCount, groupCountStandard);
    }

    @Test
    public void testFailure() {
        List<Student> students = Util.getStudents();
        Map<String, Long> groupCount = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.counting()
                ));
        groupCount.put("M-5", 2L);
        assertNotEquals(groupCount, groupCountStandard);
    }
}
