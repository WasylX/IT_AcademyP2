package task1;

class SmsService implements MessageService {
    @Override
    public void sendMessage(Message message) {
        System.out.println("SMS: " + message.getContent());
    }
}

