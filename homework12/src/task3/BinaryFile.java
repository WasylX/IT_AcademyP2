package task3;

import java.io.*;
import java.util.Random;

public class BinaryFile {
    public static void main(String[] args) {
        writeRandomNumbersToFile("random_numbers.bin", 30);

        readBinaryFileAndCalculateAverage("random_numbers.bin");
    }

    public static void writeRandomNumbersToFile(String fileName, int count) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomNumber = random.nextInt(100) + 1;
                output.writeInt(randomNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinaryFileAndCalculateAverage(String fileName) {
        try (DataInputStream input = new DataInputStream(new FileInputStream(fileName)) ) {
            int sum = 0;
            int count = 0;
            while (input.available() > 0) {
                int number = input.readInt();
                System.out.println("Число: " + number);
                sum += number;
                count++;
            }
            double average = (double) sum / count;
            System.out.println("Среднее арифметическое: " + average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

