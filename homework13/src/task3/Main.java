package task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] filenames = {"AI1.txt", "AI2.txt", "AI3.txt"};
        List<int[]> arrays = new ArrayList<>();

        ReadThread[] threads = new ReadThread[filenames.length];

        for (int i = 0; i < filenames.length; i++) {
            threads[i] = new ReadThread(filenames[i]);
            threads[i].start();
        }

        for (int i = 0; i < filenames.length; i++) {
            try {
                threads[i].join();
                arrays.add(threads[i].getArray());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < arrays.size(); i++) {
            System.out.println("Массив из файла " + filenames[i] + ":");
            for (int number : arrays.get(i)) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}

