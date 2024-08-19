package baseball.validation;

import baseball.BaseballGame;

import java.util.List;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;
import static baseball.util.Format.*;

public class InputValidation {

    // TODO: exitGame()이 여기 성격과 맞나? 분리해야 할 것 같음

    public void validateStringThreeNumberDuplicate(List<Integer> playerNumberList) {

        validateThreeNumberLength(playerNumberList);
        validateThreeNaturalNumber(playerNumberList);
        validateThreeNumberDuplicate(playerNumberList);
    }

    public void validateThreeNumberLength(List<Integer> playerNumberList) {

        if (playerNumberList.size() != NUM_LENGTH) {
            exitGame();
        }
    }

    public void validateThreeNaturalNumber(List<Integer> playerNumberList) {

        if (!playerNumberList.stream().allMatch(digit -> FIRST_RANGE <= digit && LAST_RANGE >= digit)) {
            exitGame();
        }
    }

    public void validateThreeNumberDuplicate(List<Integer> playerNumberList) {

        if (playerNumberList.stream().distinct().count() != playerNumberList.size()) {
            exitGame();
        }
    }

    public void validateOneOrTwo(String userInput) {

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

    public void exitGame() {
        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

}
