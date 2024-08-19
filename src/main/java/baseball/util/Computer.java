package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.ConstNumber.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Computer {

    public List<Integer> getRandomComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_LENGTH) {
            int randomNumber = pickNumberInRange(FIRST_RANGE, LAST_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
