package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class SaveAsThread extends Thread {
    private final String filename;
    private final int[] array;

    public SaveAsThread(String filename, int[] array) {
        this.filename = filename;
        this.array = array;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int value : array) {
                writer.write(value + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

