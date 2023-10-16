package task1;

public class StackOverflowErrorExample {
    public static void recursiveMethod() {
        recursiveMethod();
    }

    public static void main(String[] args) {
        recursiveMethod();
    }
}
