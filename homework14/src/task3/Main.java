package task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> col = Arrays.asList(2, 3, 5, 7, 11, 13, 17);

        // найти минимальное число
        int min = col.stream().mapToInt(Integer::intValue).min().orElse(-1);
        System.out.println("Min: " + min);

        // найти максимальное число
        int max = col.stream().mapToInt(Integer::intValue).max().orElse(-1);
        System.out.println("Max: " + max);

        // найти среднее арифметическое чисел
        double average = col.stream().mapToInt(Integer::intValue).average().orElse(-1.0);
        System.out.println("Average: " + average);

        // найти произведение всех чисел
        int product = col.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        // найти сумму всех чисел
        int sum = col.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // найти сумму всех цифр
        int digitsSum = col.stream()
                .flatMapToInt(number -> String.valueOf(number).chars())
                .map(Character::getNumericValue)
                .sum();
        System.out.println("Digits Sum: " + digitsSum);
    }
}

