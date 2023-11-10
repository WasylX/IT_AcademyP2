package task2;

class Process extends Thread {
    private final CriticalSection criticalSection;
    private final int iterations; // Количество итераций для процесса

    public Process(CriticalSection criticalSection, String name, int iterations) {
        super(name);
        this.criticalSection = criticalSection;
        this.iterations = iterations;
    }

    public void run() {
        for (int i = 0; i < iterations; i++) {
            criticalSection.enterCriticalSection();
            criticalSection.enterNonCriticalSection();
        }
        System.out.println(Thread.currentThread().getName() + " has completed its iterations.");
    }
}

