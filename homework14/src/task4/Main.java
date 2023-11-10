package task4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");

        List<String> result = myList.stream()
                // Удалить все содержащие “3”
                .filter(s -> !s.contains("3"))
                // Отсортировать сперва по числу (по возрастанию), потом по букве (по убыванию)
                .sorted((s1, s2) -> {
                    char char1 = s1.charAt(0);
                    char char2 = s2.charAt(0);
                    int num1 = Character.getNumericValue(s1.charAt(1));
                    int num2 = Character.getNumericValue(s2.charAt(1));
                    return num1 == num2 ? Character.compare(char2, char1) : Integer.compare(num1, num2);
                })
                // Привести в uppercase
                .map(String::toUpperCase)
                // Собрать в список
                .collect(Collectors.toList());

        // Отбросить первый и последний элемент
        if (result.size() > 2) {
            result = result.subList(1, result.size() - 1);
        }

        // Выдать на печать результат
        result.forEach(System.out::println);

        // Напечатать количество оставшихся элементов
        System.out.println("Количество оставшихся элементов: " + result.size());
    }
}

