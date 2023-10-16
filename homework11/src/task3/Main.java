package task3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        NumberGuesser guesser = new NumberGuesser();
        int maxAttempts = 1000;

        while (true) {
            int guess = new Random().nextInt(1001);

            try {
                guesser.guess(guess);
                break; // Если угадано верно, завершаем цикл.
            } catch (LessException e) {
                System.out.println(e.getMessage());
            } catch (GreaterException e) {
                System.out.println(e.getMessage());
            }

            if (guesser.getAttempts() >= maxAttempts) {
                System.out.println("Превышено максимальное количество попыток.");
                break;
            }
        }

        System.out.println("Загаданное число: " + guesser.getTargetNumber());
        System.out.println("Количество попыток: " + guesser.getAttempts());
    }
}

