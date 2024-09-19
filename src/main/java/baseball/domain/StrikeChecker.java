package baseball.domain;

import static baseball.utility.Utility.isEqual;

public class StrikeChecker implements DigitChecker {

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit) {
        return isEqual(randomNumberDigit, playerNumberDigit);
    }
}