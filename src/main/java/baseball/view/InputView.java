package baseball.view;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.NUM_LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String readPlayerNumbers() {
        String userInput = readLine().trim();
        validateUserInput(userInput);
        return userInput;
    }

    public void validateUserInput(String userInput) {
        validateHasValue(userInput);
        validateIsNumeric(userInput);
        validateNumberCount(userInput);
    }

    public void validateHasValue(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NUMBER_MESSAGE);
        }
    }

    public void validateIsNumeric(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException(IS_NOT_NUMBER);
            }
        }
    }

    public void validateNumberCount(String userInput) {
        if (userInput.length() != NUM_LENGTH) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }
    }
}
