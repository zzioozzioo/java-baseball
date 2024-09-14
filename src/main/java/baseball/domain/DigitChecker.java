package baseball.domain;

import java.util.Set;

public interface DigitChecker {
    boolean checkDigit(int randomNumberDigit, int playerNumberDigit);
    boolean checkDigit(int randomNumberDigit, int playerNumberDigit, Set<Integer> playerNumbers);
}
