package task1;

public class StackOverflowErrorExample {
    public static void main(String[] args) {
        recursiveMethod();
    }
    public static void recursiveMethod() {
        recursiveMethod();
    }
}

