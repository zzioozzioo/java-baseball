package baseball.domain;

import java.util.Set;

import static baseball.utility.Utility.isEqual;

public class BallChecker implements DigitChecker {

    private final Set<Integer> randomNumbers;

    public BallChecker(Set<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit) {
        return !isEqual(randomNumberDigit, playerNumberDigit) &&
                isInRandomNumbers(playerNumberDigit, randomNumbers);
    }

    public boolean isInRandomNumbers(int playerNumberDigit, Set<Integer> randomNumbers) {
        return randomNumbers.contains(playerNumberDigit);
    }
}
