package task2;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        final int iterations = 10;
        CriticalSection criticalSection = new CriticalSection();

        for (int i = 0; i < numberOfThreads; i++) {
            new Process(criticalSection, "Process-" + (i + 1), iterations).start();
        }
    }
}


