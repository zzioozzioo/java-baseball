package baseball.domain;

import java.util.Set;

public class BallChecker implements DigitChecker {

    private final StrikeChecker strikeChecker;
    private final Set<Integer> playerNumbers;

    public BallChecker(StrikeChecker strikeChecker, Set<Integer> playerNumbers) {
        this.strikeChecker = strikeChecker;
        this.playerNumbers = playerNumbers;
    }

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit) {
        return isEqual(randomNumberDigit, playerNumberDigit) &&
                isInPlayerNumbers(randomNumberDigit, playerNumbers) &&
                isStrike(randomNumberDigit, playerNumberDigit);
    }

    public boolean isEqual(int randomNumberDigit, int playerNumberDigit) {
        return randomNumberDigit != playerNumberDigit;
    }

    public boolean isInPlayerNumbers(int randomNumberDigit, Set<Integer> playerNumbers) {
        return playerNumbers.contains(randomNumberDigit);
    }

    public boolean isStrike(int randomNumberDigit, int playerNumberDigit) {
        return !strikeChecker.checkDigit(randomNumberDigit, playerNumberDigit);
    }

}
