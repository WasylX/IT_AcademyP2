package task3;

public class LessException extends Exception {
    public LessException() {
        super("Загаданное число больше.");
    }

    public LessException(String message) {
        super(message);
    }
}

