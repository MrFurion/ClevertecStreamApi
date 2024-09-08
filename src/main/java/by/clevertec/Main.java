package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.CarCalculator;
import by.clevertec.util.For;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {

    public static final String FEMALE = "Female";

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
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
        For.forEach(myZoo);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();

        List<String> japaneseAnimalBreeds = animals.stream()
                .filter(animal -> "Japanese".equals(animal.getOrigin()))
                .map(animal -> {
                    if (FEMALE.equals(animal.getGender())) {
                        return animal.getBread().toUpperCase();
                    }
                    return animal.getBread();
                })
                .toList();

        For.forEach(japaneseAnimalBreeds);

    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().startsWith("A"))
                .distinct()
                .peek(animal -> out.println(animal.getOrigin()))
                .toList();
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        out.println(animals.stream()
                .filter(animal -> animal.getGender().equals(FEMALE))
                .count());
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        out.println(animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian")));
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        out.println(animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals(FEMALE)));
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        out.println(animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania")));
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(animal -> out.println(animal.getAge()));
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        OptionalInt minLength = animals.stream()
                .map(animal -> animal.getBread().toCharArray())
                .mapToInt(charArray -> charArray.length)
                .min();
        if (minLength.isPresent()) {
            out.println(minLength.getAsInt());
        } else {
            out.println("null");
        }
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        OptionalInt sumAgeAnimals = OptionalInt.of(animals.stream()
                .mapToInt(Animal::getAge)
                .sum());
        out.println(sumAgeAnimals.getAsInt());
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        OptionalDouble averageAge = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average();
        out.println(averageAge.getAsDouble());
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> {
                    LocalDate birthDate = LocalDate.parse(person.getDateOfBirth().toString(), formatter);
                    int age = Period.between(birthDate, today).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .peek(person -> out.println(person.getLastName() + " " + person.getLastName()))
                .toList();
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
        LocalDate today = LocalDate.now();

        houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                        .map(person -> new AbstractMap.SimpleEntry<>(house.getBuildingType(), person)))
                .sorted(Comparator.comparing((AbstractMap.SimpleEntry<String, Person> entry) -> "Hospital".equals(entry.getKey()) ? 0 : 1)
                        .thenComparing(entry -> {
                            if ("Hospital".equals(entry.getKey())) {
                                return 0;
                            }
                            LocalDate birthDate = entry.getValue().getDateOfBirth();
                            int age = Period.between(birthDate, today).getYears();
                            return age < 18 ? 0 : age > 62 ? 1 : 2;
                        }))
                .limit(500)
                .peek(entry -> out.println(entry.getValue().getFirstName() + " "
                        + entry.getValue().getLastName()
                        + " date of birth : "
                        + entry.getValue().getDateOfBirth()
                        + " local - "
                        + entry.getKey()))
                .toList();
    }

    public static void task14() {
        List<Car> cars = Util.getCars();

        Map<String, Double> transportationCosts = cars.stream()
                .collect(Collectors.groupingBy(car -> {
                    if ("Jaguar".equals(car.getCarMake()) || "White".equals(car.getColor())) {
                        return "Turkmenistan";
                    } else if (car.getMass() < 1500 && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())) {
                        return "Uzbekistan";
                    } else if ("Black".equals(car.getColor()) && car.getMass() > 4000 ||
                            List.of("GMC", "Dodge").contains(car.getCarMake())) {
                        return "Kazakhstan";
                    } else if (car.getReleaseYear() < 1982 || List.of("Civic", "Cherokee").contains(car.getCarModel())) {
                        return "Kyrgyzstan";
                    } else if (!List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor()) || car.getPrice() > 40000) {
                        return "Russia";
                    } else if (car.getVin().contains("59")) {
                        return "Mongolia";
                    } else {
                        return "Discarded";
                    }
                }, Collectors.summingInt(Car::getMass)))
                .entrySet().stream()
                .filter(entry -> !"Discarded".equals(entry.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * 7.14 / 1000
                ));
        double totalRevenue = transportationCosts.values().stream().mapToDouble(Double::doubleValue).sum();
        out.println("Total Revenue: $" + totalRevenue);

        CarCalculator.printTransportCosts(transportationCosts);
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        double waterCostPerCubicMeter = 1.39;
        double totalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin, Comparator.reverseOrder())
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay, Comparator.reverseOrder()))
                .filter(flower -> flower.getCommonName().toUpperCase().compareTo("S") >= 0 ||
                        flower.getCommonName().toUpperCase().compareTo("C") <= 0)
                .filter(flower -> flower.isShadePreferred() || List.of("Glass", "Aluminium", "Steel").containsAll(flower.getFlowerVaseMaterial()))
                .map(flower -> {
                    double waterCost = flower.getWaterConsumptionPerDay() * 5 * 365 * waterCostPerCubicMeter;
                    double totalFlowerCost = flower.getPrice() + waterCost;
                    return totalFlowerCost;
                })
                .reduce(0.0, Double::sum);
        out.println("Total Cost: $" + totalCost);
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
