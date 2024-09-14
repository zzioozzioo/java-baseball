package baseball.domain;


import java.util.Set;

public class StrikeChecker implements DigitChecker {

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit) {
        return randomNumberDigit == playerNumberDigit;
    }

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit, Set<Integer> playerNumbers) {
        throw new UnsupportedOperationException("This method does not support playerNumbers.");
    }
}
