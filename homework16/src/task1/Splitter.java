package task1;

class Splitter {
    private final MessageService emailService;
    private final MessageService smsService;

    public Splitter(MessageService emailService, MessageService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void splitAndSend(Message originalMessage) {
        // Создаем два сообщения на основе оригинального
        EmailMessage emailMessage = new EmailMessage(originalMessage.getContent());
        SmsMessage smsMessage = new SmsMessage(originalMessage.getContent());

        // Отправляем сообщения
        emailService.sendMessage(emailMessage);
        smsService.sendMessage(smsMessage);
    }
}

