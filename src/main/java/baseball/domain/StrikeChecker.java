package baseball.domain;

import java.util.Set;

public class StrikeChecker implements DigitChecker {

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit, Set<Integer> playerNumbers) {
        return randomNumberDigit == playerNumberDigit;
    }
}
