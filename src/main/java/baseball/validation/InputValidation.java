package baseball.validation;

import java.util.List;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;
import static baseball.util.Format.*;

public class InputValidation {

    public static void validateStringThreeNumberDuplicate(List<Integer> playerNumberList) {

        validateThreeNumberLength(playerNumberList);
        validateThreeNaturalNumber(playerNumberList);
        validateThreeNumberDuplicate(playerNumberList);
    }

    public static void validateThreeNumberLength(List<Integer> playerNumberList) {

        if (playerNumberList.size() != NUM_LENGTH) {
            exitGame();
        }
    }

    public static void validateThreeNaturalNumber(List<Integer> playerNumberList) {

        if (!playerNumberList.stream().allMatch(digit -> FIRST_RANGE <= digit && LAST_RANGE >= digit)) {
            exitGame();
        }
    }

    public static void validateThreeNumberDuplicate(List<Integer> playerNumberList) {

        if (playerNumberList.stream().distinct().count() != playerNumberList.size()) {
            exitGame();
        }
    }

    public static void validateOneOrTwo(String userInput) {

        if (!userInput.chars().allMatch(Character::isDigit)) {
            exitGame();
        }

        int integerUserInput = StringToInt(userInput);
        if (integerUserInput != RESTART_NUM && integerUserInput != EXIT_NUM) {
            exitGame();
        }
        if (userInput.isEmpty()) {
            exitGame();
        }
    }

    public static void exitGame() {
        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

}
