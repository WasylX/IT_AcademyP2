package task1;

import java.util.LinkedList;
import java.util.List;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

abstract class AbstractMessageService implements MessageService {
    protected final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    protected volatile boolean running = true;

    public void sendMessage(String message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void runService() {
        new Thread(() -> {
            try {
                while (running) {
                    String message = queue.take();
                    processMessage(message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                serviceInterrupted();
            }
        }).start();
    }

    public void stopService() {
        running = false;
    }

    protected abstract void processMessage(String message);
    protected abstract void serviceInterrupted();
}
