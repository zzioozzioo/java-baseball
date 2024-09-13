package baseball.domain;

import java.util.Iterator;
import java.util.Set;

public class StrikeChecker implements DigitChecker {

    @Override
    public boolean checkDigit(Iterator<Integer> randomNumbersIterator, Iterator<Integer> playerNumbersIterator, Set<Integer> playerNumbers) {
        int randomNumberDigit = randomNumbersIterator.next();
        int playerNumberDigit = playerNumbersIterator.next();

        return randomNumberDigit == playerNumberDigit;
    }

    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit) {
        return randomNumberDigit == playerNumberDigit;
    }
}
