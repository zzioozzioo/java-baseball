package baseball.domain;

import java.util.HashSet;
import java.util.Set;

import static baseball.constant.ConstNumber.NUM_LENGTH;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private final Set<Integer> randomNumber = new HashSet<>();

    public Set<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void generateRandomNumber() {

        for (int i = 0; i < NUM_LENGTH; i++) {
            int number = pickNumberInRange(Range.FIRST_RANGE.getNumber(), Range.LAST_RANGE.getNumber());
            addRandomNumber(number);
        }
    }
    public void addRandomNumber(int number) {
        validateRandomNumber(number);
        randomNumber.add(number);
    }

    public void validateRandomNumber(int number) {
        if (!randomNumber.contains(number)) {
            randomNumber.add(number);
        }
    }
}
