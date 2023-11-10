package task1;

class Subsystem {
    private final String name;
    private final Splitter splitter;

    public Subsystem(String name, Splitter splitter) {
        this.name = name;
        this.splitter = splitter;
    }

    public void generateAndSendMessage(String content) {
        Message message = new Message(content);
        System.out.println(name + " generated a message.");
        splitter.splitAndSend(message);
    }
}

