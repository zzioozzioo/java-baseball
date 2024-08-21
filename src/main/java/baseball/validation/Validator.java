package baseball.validation;

import baseball.util.Converter;

import java.util.List;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;

public class Validator {

    private final Converter converter = new Converter();

    public void validateStringThreeNumberDuplicate(List<Integer> playerNumberList) {

        validateThreeNumberLength(playerNumberList);
        validateThreeNumberRange(playerNumberList);
        validateThreeNumberDuplicate(playerNumberList);
    }

    public void validateThreeNumberLength(List<Integer> playerNumberList) {

        if (playerNumberList.size() != NUM_LENGTH) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_LENGTH_MESSAGE);
        }
    }

    public void validateThreeNumberRange(List<Integer> playerNumberList) {

        if (!playerNumberList.stream().allMatch(digit -> FIRST_RANGE <= digit && LAST_RANGE >= digit)) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_RANGE_MESSAGE);
        }
    }

    public void validateThreeNumberDuplicate(List<Integer> playerNumberList) {

        if (playerNumberList.stream().distinct().count() != playerNumberList.size()) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public void validateOneOrTwo(String userInput) {

        isNumeric(userInput);
        isOneOrTwo(userInput);
    }

    public void isNumeric(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(VALIDATE_ONE_OR_TWO_IS_DIGIT_MESSAGE);
        }
    }

    public void isOneOrTwo(String userInput) {
        int integerUserInput = converter.toInt(userInput);
        if (integerUserInput != RESTART_NUM && integerUserInput != EXIT_NUM) {
            throw new IllegalArgumentException(VALIDATE_ONE_OR_TWO_WRONG_NUM_MESSAGE);
        }
    }

}
