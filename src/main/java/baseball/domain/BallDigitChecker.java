package baseball.domain;

import java.util.Set;

public interface BallDigitChecker {
    boolean checkDigit(int randomNumberDigit, int playerNumberDigit, Set<Integer> playerNumbers);
}
