package task1;

import java.util.LinkedList;
import java.util.List;

abstract class AbstractMessageService implements MessageService {
    protected final List<String> queue = new LinkedList<>();
    protected volatile boolean running = true;

    protected synchronized String getNextMessage() throws InterruptedException {
        while (queue.isEmpty() && running) {
            wait();
        }
        return queue.isEmpty() ? null : queue.remove(0);
    }

    public synchronized void sendMessage(String message) {
        queue.add(message);
        notifyAll();
    }

    public void runService() {
        new Thread(() -> {
            try {
                while (running) {
                    String message = getNextMessage();
                    if (message != null) {
                        processMessage(message);
                    } else {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                serviceInterrupted();
            }
        }).start();
    }

    public synchronized void stopService() {
        running = false;
        notifyAll();
    }

    protected abstract void processMessage(String message);
    protected abstract void serviceInterrupted();
}

