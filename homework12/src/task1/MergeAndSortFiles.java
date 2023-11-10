package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MergeAndSortFiles {
    public static void main(String[] args) {
        createRandomFile("in1.txt", 1, 1000);
        createRandomFile("in2.txt", 1001, 2000);

        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("in1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                numbers.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("in2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                numbers.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(numbers);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {
            for (int number : numbers) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createRandomFile(String fileName, int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers, new Random()); // Перемешиваем числа в случайном порядке

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int number : numbers) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

