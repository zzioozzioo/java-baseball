package baseball.domain;


public class StrikeChecker implements DigitChecker {

    @Override
    public boolean checkDigit(int randomNumberDigit, int playerNumberDigit) {
        return randomNumberDigit == playerNumberDigit;
    }
}
