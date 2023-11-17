package task1;

class SmsService extends AbstractMessageService {
    protected void processMessage(String message) {
        System.out.println("SMS sent: " + message);
    }

    protected void serviceInterrupted() {
        System.out.println("SMS service interrupted.");
    }
}

