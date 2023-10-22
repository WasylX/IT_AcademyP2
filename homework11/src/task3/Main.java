package task3;

public class Main {
    public static void main(String[] args) {
        NumberGuesser guesser = new NumberGuesser();

        int min = 0;
        int max = 1000;
        int guess;
        int attempts = 1;

        while (true) {
            guess = min + (max - min) / 2;

            try {
                guesser.checkGuess(guess);
                System.out.println("Вы угадали! Загаданное число: " + guess);
                System.out.println("Количество попыток: " + attempts);
                break;
            } catch (LessException e) {
                System.out.println("Попытка #" + attempts + ": " + e.getMessage());
                min = guess + 1;
            } catch (GreaterException e) {
                System.out.println("Попытка #" + attempts + ": " + e.getMessage());
                max = guess - 1;
            }

            attempts++;
        }
    }
}

