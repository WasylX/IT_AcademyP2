package task5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Kail", "A", 1, Arrays.asList(4, 5, 4)),
                new Student("Janet", "B", 2, Arrays.asList(2, 2, 3)),
                new Student("Anna", "A", 3, Arrays.asList(4, 3, 4)),
                new Student("Michael", "C", 1, Arrays.asList(5, 5, 5)),
                new Student("Brian", "B", 2, Arrays.asList(1, 2, 1))
        );

        List<Student> underachievers = students.stream()
                .filter(s -> s.getAverageGrade() < 3)
                .sorted(Comparator.comparing(Student::getName))
                .toList();

        // Отсортировать список отстающих студентов в алфавитном порядке и вывести на экран.
        underachievers.forEach(s -> System.out.println("Список отстающих студентов: " + s.getName()));

        System.out.println("-------------------------------------------");

        // Перевести всех студентов с баллом>=3 на следующий курс.
        students.stream()
                .filter(s -> s.getAverageGrade() >= 3)
                .forEach(s -> {
                    s.promote();
                    System.out.println(s.getName() + " переведён на курс " + s.getCourse());
                });

        System.out.println("-------------------------------------------");

        Map<Integer, List<Student>> map = students.stream()
                .collect(Collectors.groupingBy(s -> (int) s.getAverageGrade()));

        map.forEach((key, value) -> {
            System.out.println("В нижняя граница средней оценки: " + key);
            value.forEach(s -> System.out.println(s.getName()));
        });

        System.out.println("-------------------------------------------");
    }
}

