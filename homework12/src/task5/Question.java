package task5;

class Question {
    private String text;
    private String topic;
    private String group;

    public Question(String text, String topic, String group) {
        this.text = text;
        this.topic = topic;
        this.group = group;
    }

    public String getText() {
        return text;
    }

    public String getTopic() {
        return topic;
    }

    public String getGroup() {
        return group;
    }
}

