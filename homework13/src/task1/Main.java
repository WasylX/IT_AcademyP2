package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        FindMaxRunnable findMaxRunnable = new FindMaxRunnable(array);
        Thread maxThread = new Thread(findMaxRunnable);

        FindMinRunnable findMinRunnable = new FindMinRunnable(array);
        Thread minThread = new Thread(findMinRunnable);

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();

            System.out.println("Максимум: " + findMaxRunnable.getMax());
            System.out.println("Минимум: " + findMinRunnable.getMin());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

