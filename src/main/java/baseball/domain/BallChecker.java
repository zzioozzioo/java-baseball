package baseball.domain;

import java.util.Set;

public class BallChecker implements DigitChecker {

    private final StrikeChecker strikeChecker;

    public BallChecker(StrikeChecker strikeChecker) {
        this.strikeChecker = strikeChecker;
    }

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit) {
        throw new UnsupportedOperationException("This method does not support this method");
    }

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit, Set<Integer> playerNumbers) {
        return randomNumberDigit != playerNumberDigit &&
                playerNumbers.contains(randomNumberDigit) &&
                !strikeChecker.checkDigit(randomNumberDigit, playerNumberDigit);
    }

}
