package baseball.domain;

import java.util.Iterator;
import java.util.Set;

import static baseball.constant.ConstNumber.NUM_LENGTH;

public class Strike {
    private int strike;
    private final DigitChecker checker;

    public Strike(DigitChecker checker) {
        this.checker = checker;
    }

    public int getStrike() {
        return strike;
    }

    public void countStrike(Set<Integer> randomNumbers, Set<Integer> playerNumbers) {

        Iterator<Integer> randomNumbersIterator = randomNumbers.iterator();
        Iterator<Integer> playerNumbersIterator = playerNumbers.iterator();

        for (int i = 0; i < NUM_LENGTH; i++) {
            if (checker.checkDigit(randomNumbersIterator.next(), playerNumbersIterator.next())) {
                strike++;
            }
        }
    }

}
