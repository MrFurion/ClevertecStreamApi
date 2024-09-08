package by.clevertec.tests;

import by.clevertec.model.Person;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTask12 {

    static {
        listStandardPeople = List.of(
                "Goddart Bentall", "Harland Batchelour", "Cointon Lethbridge",
                "Beauregard Robet", "Estevan Fernanando", "Elnar Chisholm",
                "Wendall Duligal", "Gian Worthington", "Land Yexley",
                "Staford Johanssen", "Franciskus Beckford", "Kendell Laidler",
                "Sayres Pauncefoot", "Alberto Claringbold", "Vincent Kahler",
                "Sylvan Armin", "Purcell Tolan", "Ryon Coulthard",
                "Fidelio Cardenoso", "Kristian Warlock", "Kinsley Earey",
                "Abdel Iban", "Grove Fassum", "Archibold Shavel",
                "Enrico Seydlitz", "Jamill Petticrow", "Bourke Mote",
                "Quinn Alway", "Gasper Phifer", "Vassily Janny",
                "Lewes Gergler", "Neron Deverson", "Ruddie Anlay",
                "Alphonse Sopp", "Rudolf Guierre", "Dalston Minard",
                "Micky Bockings", "Even Brame", "Drake McCalister",
                "Graham Guiso", "Kin Buckenhill", "Kennie Brothers",
                "Grady Richten", "Ban McKeefry", "Giffy Clemente",
                "Sheppard Mundwell", "Hugo Spaldin", "Baillie Joannidi",
                "Desmond Ternott", "Desmund Danforth", "Burg Ranaghan",
                "James Gladwin", "Quent Hachard", "Free Killgus",
                "Fairleigh Roberti", "Giovanni Handling", "Terry De Bruyn",
                "Harbert Whodcoat", "Ambros Wardrope", "Jarret Lodge",
                "Francklyn Blanko", "Lev Chasson", "Domenic Twentyman",
                "Davon Quinsee", "Rod Nystrom", "Purcell Medway",
                "Winfred Fishpoole", "Robinet Foakes", "Darnall Gilfether",
                "Donalt Tobias", "Kile Casale", "Kevon Schottli",
                "Mohammed Feore", "Harwilll Risebrow", "Mervin Lewer",
                "Brennan Giggs", "Jessie Melesk", "Dukie Guterson",
                "Sheridan Jeaneau"
        );
    }

    private static List<String> listStandardPeople;

    @Test
    public void testSuccess() {
        List<Person> persons = Util.getPersons();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Person> listPeople = persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> {
                    LocalDate birthDate = LocalDate.parse(person.getDateOfBirth().toString(), formatter);
                    int age = Period.between(birthDate, today).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .toList();

        List<String> makeListPeople = new ArrayList<>();
        for (Person persen : listPeople) {
            makeListPeople.add(persen.getFirstName() + " " + persen.getLastName());
        }

        assertEquals(makeListPeople, listStandardPeople);
    }

    @Test
    public void testFailure() {
        List<Person> persons = Util.getPersons();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Person> listPeople = persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> {
                    LocalDate birthDate = LocalDate.parse(person.getDateOfBirth().toString(), formatter);
                    int age = Period.between(birthDate, today).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .toList();

        List<String> makeListPeople = new ArrayList<>();
        for (Person persen : listPeople) {
            makeListPeople.add(persen.getFirstName() + " " + persen.getLastName());
        }
        makeListPeople.add(" no name");

        assertNotEquals(makeListPeople, listStandardPeople);
    }
}
