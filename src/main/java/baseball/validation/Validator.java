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
            exitGameByValidation();
        }
    }

    public void validateThreeNumberRange(List<Integer> playerNumberList) {

        if (!playerNumberList.stream().allMatch(digit -> FIRST_RANGE <= digit && LAST_RANGE >= digit)) {
            exitGameByValidation();
        }
    }

    public void validateThreeNumberDuplicate(List<Integer> playerNumberList) {

        if (playerNumberList.stream().distinct().count() != playerNumberList.size()) {
            exitGameByValidation();
        }
    }

    public void validateOneOrTwo(String userInput) {

        if (!userInput.chars().allMatch(Character::isDigit)) {
            exitGameByValidation();
        }

        int integerUserInput = converter.toInt(userInput);
        if (integerUserInput != RESTART_NUM && integerUserInput != EXIT_NUM) {
            exitGameByValidation();
        }
    }

    public void exitGameByValidation() {
        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

}
