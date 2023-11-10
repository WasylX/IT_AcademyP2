package task1;

public class Main {
    public static void main(String[] args) {
        // Инициализируем сервисы и сплиттер
        MessageService emailService = new EmailService();
        MessageService smsService = new SmsService();
        Splitter splitter = new Splitter(emailService, smsService);

        // Инициализируем подсистемы
        Subsystem subsystemA = new Subsystem("SubsystemA", splitter);
        Subsystem subsystemB = new Subsystem("SubsystemB", splitter);
        Subsystem subsystemC = new Subsystem("SubsystemC", splitter);

        // Генерируем и отправляем сообщения
        subsystemA.generateAndSendMessage("Alert from A!");
        subsystemB.generateAndSendMessage("Notification from B!");
        subsystemC.generateAndSendMessage("Warning from C!");
    }
}

