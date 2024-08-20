package baseball.validation;

import baseball.util.Format;
import baseball.util.GameController;

import java.util.List;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;

public class InputValidation {

    private final Format format = new Format();
    private final GameController gameController = new GameController();

    public void validateStringThreeNumberDuplicate(List<Integer> playerNumberList) {

        validateThreeNumberLength(playerNumberList);
        validateThreeNaturalNumber(playerNumberList);
        validateThreeNumberDuplicate(playerNumberList);
    }

    public void validateThreeNumberLength(List<Integer> playerNumberList) {

        if (playerNumberList.size() != NUM_LENGTH) {
            gameController.exitGame();
        }
    }

    public void validateThreeNaturalNumber(List<Integer> playerNumberList) {

        if (!playerNumberList.stream().allMatch(digit -> FIRST_RANGE <= digit && LAST_RANGE >= digit)) {
            gameController.exitGame();
        }
    }

    public void validateThreeNumberDuplicate(List<Integer> playerNumberList) {

        if (playerNumberList.stream().distinct().count() != playerNumberList.size()) {
            gameController.exitGame();
        }
    }

    public void validateOneOrTwo(String userInput) {

        if (!userInput.chars().allMatch(Character::isDigit)) {
            gameController.exitGame();
        }

        int integerUserInput = format.StringToInt(userInput);
        if (integerUserInput != RESTART_NUM && integerUserInput != EXIT_NUM) {
            gameController.exitGame();
        }
        if (userInput.isEmpty()) {
            gameController.exitGame();
        }
    }

}
