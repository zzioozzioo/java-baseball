package baseball.validation;

import baseball.domain.Range;
import baseball.util.Converter;

import java.util.List;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;

public class Validator {

    private final Converter converter = new Converter();

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
