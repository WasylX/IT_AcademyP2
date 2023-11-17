package task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        EmailService emailService = new EmailService();
        SmsService smsService = new SmsService();
        Splitter splitter = new Splitter(emailService, smsService);

        emailService.runService();
        smsService.runService();
        splitter.runSplitter();

        int totalIterations = 0;

        for (int i = 0; i < 3; i++) {
            Subsystem subsystem = new Subsystem("Subsystem" + (char) ('A' + i), splitter);
            executor.execute(subsystem);
        }

        try {
            while (totalIterations < 10) {
                Thread.sleep(1000);
                totalIterations += 1;
            }

            splitter.stopSplitter();
            emailService.stopService();
            smsService.stopService();

            executor.shutdown();

            System.out.println("All subsystems have completed. Services and splitter are stopped.");
            System.exit(0);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }
    }
}
