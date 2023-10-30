package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadThread extends Thread {
    private final String filename;
    private int[] array;

    public ReadThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int N = Integer.parseInt(reader.readLine());
            array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getArray() {
        return array;
    }
}

