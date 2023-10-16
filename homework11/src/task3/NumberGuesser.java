package task3;

import java.util.Random;

class NumberGuesser {
    private int targetNumber;
    private int attempts;

    public NumberGuesser() {
        Random rand = new Random();
        targetNumber = rand.nextInt(1001); // Загадываем случайное число от 0 до 1000.
        attempts = 0;
    }

    public void guess(int number) throws LessException, GreaterException {
        attempts++;

        if (number < targetNumber) {
            throw new LessException("Меньше загаданного числа.");
        } else if (number > targetNumber) {
            throw new GreaterException("Больше загаданного числа.");
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public int getTargetNumber() {
        return targetNumber;
    }
}

