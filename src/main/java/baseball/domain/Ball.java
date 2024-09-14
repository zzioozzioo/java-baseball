package baseball.domain;

import java.util.Iterator;
import java.util.Set;

import static baseball.constant.ConstNumber.NUM_LENGTH;

public class Ball {
    private int ball;
    private final BallChecker checker;

    public Ball(BallChecker checker) {
        this.checker = checker;
    }

    public int getBall() {
        return ball;
    }

    public void countBall(Set<Integer> randomNumbers, Set<Integer> playerNumbers) {

        Iterator<Integer> randomNumbersIterator = randomNumbers.iterator();
        Iterator<Integer> playerNumbersIterator = playerNumbers.iterator();

        for (int i = 0; i < NUM_LENGTH; i++) {
            if (checker.checkDigit(randomNumbersIterator.next(), playerNumbersIterator.next())) {
                ball++;
            }
        }
    }
}
