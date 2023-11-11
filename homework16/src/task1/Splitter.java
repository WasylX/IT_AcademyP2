package task1;

import java.util.LinkedList;
import java.util.List;

class Splitter {
    private final MessageService emailService;
    private final MessageService smsService;
    private final List<String> queue = new LinkedList<>();
    private volatile boolean running = true;

    public Splitter(MessageService emailService, MessageService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public synchronized void splitAndSend(String message) {
        queue.add(message);
        notifyAll();
    }

    private synchronized String getNextMessage() throws InterruptedException {
        while (queue.isEmpty() && running) {
            wait();
        }
        return queue.isEmpty() ? null : queue.remove(0);
    }

    public void runSplitter() {
        new Thread(() -> {
            try {
                while (running) {
                    String message = getNextMessage();
                    if (message != null) {
                        emailService.sendMessage(message + " via Email");
                        smsService.sendMessage(message + " via SMS");
                    } else {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Splitter interrupted.");
            }
        }).start();
    }

    public synchronized void stopSplitter() {
        running = false;
        notifyAll();
    }
}

