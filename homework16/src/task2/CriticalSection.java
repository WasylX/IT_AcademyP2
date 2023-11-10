package task2;

class CriticalSection {
    private final Object lock = new Object();

    // Метод для входа в критическую секцию
    public void enterCriticalSection() {
        synchronized(lock) {
            // Операции, выполняемые в критической секции
            System.out.println(Thread.currentThread().getName() + " is in the critical section");
            // Эмуляция работы с общим ресурсом
            try {
                Thread.sleep(100); // Для имитации работы
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Метод для входа в некритическую секцию
    public void enterNonCriticalSection() {
        // Операции, выполняемые в некритической секции
        System.out.println(Thread.currentThread().getName() + " is in the non-critical section");
        // Эмуляция работы, не требующей синхронизации
        try {
            Thread.sleep(100); // Для имитации работы
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

