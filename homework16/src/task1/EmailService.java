package task1;

class EmailService implements MessageService {
    @Override
    public void sendMessage(Message message) {
        System.out.println("Email: " + message.getContent());
    }
}

