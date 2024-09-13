package baseball.domain;

import java.util.Iterator;
import java.util.Set;

public interface DigitChecker {
    boolean checkDigit(Iterator<Integer> randomNumbersIterator, Iterator<Integer> playerNumbersIterator, Set<Integer> playerNumbers);
}
