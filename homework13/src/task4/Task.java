package task4;

class Task {
    private final String message;

     Task(String message) {
        this.message = message;
    }

    public void execute() {
        System.out.println("Выполняется: " + message);
    }
}

