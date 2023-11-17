package task1;

import java.util.LinkedList;
import java.util.List;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Splitter {
    private final MessageService emailService;
    private final MessageService smsService;
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public Splitter(MessageService emailService, MessageService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void splitAndSend(String message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error adding message to queue: " + e.getMessage());
        }
    }

    public void runSplitter() {
        new Thread(() -> {
            try {
                while (running) {
                    String message = queue.take();
                    emailService.sendMessage(message + " via Email");
                    smsService.sendMessage(message + " via SMS");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Splitter interrupted.");
            }
        }).start();
    }

    public void stopSplitter() {
        running = false;
    }
}

