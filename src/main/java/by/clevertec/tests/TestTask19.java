package by.clevertec.tests;

import by.clevertec.model.Examination;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask19 {
    @Test
    public void testSuccess() {
        String groupName = "C-2";
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        List<String> listStudents = students.stream()
                .filter(student -> student.getGroup().equals(groupName))
                .filter(student -> examinations.stream()
                        .anyMatch(examination -> examination.getStudentId() == student.getId()
                                && examination.getExam3() > 4))
                .map(Student::getSurname)
                .toList();
        List<String> listStandard = List.of("Carter", "Adams", "Smith", "Williams");

        assertEquals(listStudents, listStandard);
    }

    @Test
    public void testFailure() {
        String groupName = "C-2";
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        List<String> listStudents = students.stream()
                .filter(student -> student.getGroup().equals(groupName))
                .filter(student -> examinations.stream()
                        .anyMatch(examination -> examination.getStudentId() == student.getId()
                                && examination.getExam3() > 4))
                .map(Student::getSurname)
                .toList();
        List<String> listStandard = List.of("Carter", "Adams", "Smith", "Williams", "no name");

        assertNotEquals(listStudents, listStandard);
    }
}
