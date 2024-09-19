package baseball.view;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.NUM_LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String readPlayerNumbers() {
        String playerNumbersInput = readLine().trim();
        validatePlayerNumbers(playerNumbersInput);
        return playerNumbersInput;
    }

    public void validatePlayerNumbers(String input) {
        validateHasValue(input);
        validateIsNumeric(input);
        validatePlayerNumbersLength(input);
    }

    public void validateHasValue(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NUMBER_MESSAGE);
        }
    }

    public void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    public void validatePlayerNumbersLength(String input) {
        if (input.length() != NUM_LENGTH) {
            throw new IllegalArgumentException(INVALID_NUMBER_LENGTH);
        }
    }

    public String readGameCommand() {
        String gameCommandInput = readLine().trim();
        validateGameCommand(gameCommandInput);
        return gameCommandInput;
    }

    public void validateGameCommand(String input) {
        validateHasValue(input);
        validateIsNumeric(input);
        validateGameCommandLength(input);
    }

    public void validateGameCommandLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_LENGTH);
        }
    }
}
