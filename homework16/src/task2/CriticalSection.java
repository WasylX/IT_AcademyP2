package task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CriticalSection {
    private final Lock lock = new ReentrantLock();

    public void enterCriticalSection() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is in the critical section");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void enterNonCriticalSection() {
        System.out.println(Thread.currentThread().getName() + " is in the non-critical section");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

