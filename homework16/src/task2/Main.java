package task2;

public class Main {
    public static void main(String[] args) {
        final int N = 5; // Количество процессов
        final int iterations = 10; // Количество итераций для каждого процесса
        CriticalSection criticalSection = new CriticalSection();

        // Создаем и запускаем процессы
        for (int i = 0; i < N; i++) {
            new Process(criticalSection, "Process-" + (i + 1), iterations).start();
        }
    }
}

