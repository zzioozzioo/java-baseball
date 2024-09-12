package baseball.domain;

import java.util.Set;

import static baseball.constant.ConstNumber.NUM_LENGTH;

public class Ball {
    private int ball;

    public int getBall() {
        return ball;
    }

    public void countBall(Set<Integer> randomNumbers, Set<Integer> playerNumbers, Strike strike) {
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (isDigitBall(randomNumbers, playerNumbers, i, strike)) {
                ball++;
            }
        }
    }

    private boolean isDigitBall(Set<Integer> randomNumbers, Set<Integer> playerNumbers, int i, Strike strike) {
        int randomNumberDigit = randomNumbers.get(i);
        int playerNumberDigit = playerNumbers.get(i);

        if (randomNumberDigit != playerNumberDigit &&
                playerNumbers.contains(randomNumberDigit) &&
                !strike.isDigitStrike(randomNumbers, playerNumbers, i)) {
            return true;
        }
        return false;

    }
}
