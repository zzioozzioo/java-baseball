package baseball.domain;

import java.util.Set;

public class BallChecker implements BallDigitChecker {

    private final StrikeChecker strikeChecker;

    public BallChecker(StrikeChecker strikeChecker) {
        this.strikeChecker = strikeChecker;
    }


    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit, Set<Integer> playerNumbers) {

        // 스트라이크가 아닌 경우에만 볼을 카운트
        return randomNumberDigit != playerNumberDigit &&
                playerNumbers.contains(randomNumberDigit) &&
                !strikeChecker.checkDigit(randomNumberDigit, playerNumberDigit);
    }
}
