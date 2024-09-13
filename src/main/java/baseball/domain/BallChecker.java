package baseball.domain;

import java.util.Iterator;
import java.util.Set;

public class BallChecker implements DigitChecker {

    private final StrikeChecker strikeChecker;

    public BallChecker(StrikeChecker strikeChecker) {
        this.strikeChecker = strikeChecker;
    }


    @Override
    public boolean checkDigit(Iterator<Integer> randomNumbersIterator, Iterator<Integer> playerNumbersIterator, Set<Integer> playerNumbers) {
        int randomNumberDigit = randomNumbersIterator.next();
        int playerNumberDigit = playerNumbersIterator.next();

        // 스트라이크가 아닌 경우에만 볼을 카운트
        return randomNumberDigit != playerNumberDigit &&
                playerNumbers.contains(randomNumberDigit) &&
                !strikeChecker.checkDigit(randomNumberDigit, playerNumberDigit);
    }
}
