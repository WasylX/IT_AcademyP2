package task4;

import java.util.LinkedList;
import java.util.Queue;

class Executor extends Thread {
    private final Queue<Task> tasks = new LinkedList<>();
    private volatile boolean running = true;

    public void addTask(Task task) {
        synchronized (tasks) {
            tasks.offer(task);
            tasks.notify();
        }
    }

    public void stopExecutor() {
        running = false;
        synchronized (tasks) {
            tasks.notify();
        }
    }

    @Override
    public void run() {
        while (running || !tasks.isEmpty()) {
            synchronized (tasks) {
                while (tasks.isEmpty() && running) {
                    try {
                        tasks.wait(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                Task task = tasks.poll();
                if (task != null) {
                    task.execute();
                }
            }
        }
    }

    public void terminate() {
        stopExecutor();
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

