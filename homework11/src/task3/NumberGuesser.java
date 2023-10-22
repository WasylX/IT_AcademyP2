package task3;

import java.util.Random;

public class NumberGuesser {
    private int targetNumber;

    public NumberGuesser() {
        targetNumber = new Random().nextInt(1001);
    }

    public void checkGuess(int number) throws LessException, GreaterException {
        if (number < targetNumber) {
            throw new LessException();
        } else if (number > targetNumber) {
            throw new GreaterException();
        }
    }
}

