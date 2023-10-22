package task3;

public class GreaterException extends Exception {
    public GreaterException() {
        super("Загаданное число меньше.");
    }

    public GreaterException(String message) {
        super(message);
    }
}

