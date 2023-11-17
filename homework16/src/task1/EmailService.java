package task1;

class EmailService extends AbstractMessageService {
    protected void processMessage(String message) {
        System.out.println("Email sent: " + message);
    }

    protected void serviceInterrupted() {
        System.out.println("Email service interrupted.");
    }
}

