package by.clevertec.tests;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask16 {
    @Test
    public void testSuccess() {
        List<Student> students = Util.getStudents();
        List<Student> list = students.stream()
                .filter(student -> student.getAge() < 18)
                .toList();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testFailure() {
        List<Student> students = Util.getStudents();
        List<Student> list = students.stream()
                .filter(student -> student.getAge() <= 18)
                .toList();
        assertNotEquals(list.size(), 0);
    }

}
