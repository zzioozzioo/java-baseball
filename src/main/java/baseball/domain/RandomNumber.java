package baseball.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.constant.ConstNumber.NUM_LENGTH;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private final Set<Integer> randomNumber = new LinkedHashSet<>();

    public Set<Integer> getRandomNumbers() {
        return randomNumber;
    }

    public void generateRandomNumbers() {

        while (randomNumber.size() < NUM_LENGTH) {
            int number = pickNumberInRange(Range.FIRST_RANGE.getNumber(), Range.LAST_RANGE.getNumber());
            addRandomNumber(number);
        }

    }
    public void addRandomNumber(int number) {
        randomNumber.add(number);
    }
}
