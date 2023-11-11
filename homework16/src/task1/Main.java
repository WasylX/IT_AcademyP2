package task1;

public class Main {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        SmsService smsService = new SmsService();
        Splitter splitter = new Splitter(emailService, smsService);

        emailService.runService();
        smsService.runService();
        splitter.runSplitter();

        Subsystem subsystemA = new Subsystem("SubsystemA", splitter);
        Subsystem subsystemB = new Subsystem("SubsystemB", splitter);
        Subsystem subsystemC = new Subsystem("SubsystemC", splitter);
        
        subsystemA.start();
        subsystemB.start();
        subsystemC.start();

        try {
            subsystemA.join();
            subsystemB.join();
            subsystemC.join();

            splitter.stopSplitter();
            emailService.stopService();
            smsService.stopService();

            System.out.println("All subsystems have completed. Services and splitter are stopped.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }
    }
}

