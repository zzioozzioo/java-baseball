package baseball.util;

import baseball.validation.InputValidation;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.RESTART_NUM;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {

    private final InputValidation validation = new InputValidation();
    private final Format format = new Format();

    public boolean restartGame() {
        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        String userInput = readLine();
        validation.validateOneOrTwo(userInput);

        int integerUserInput = format.StringToInt(userInput);

        if (integerUserInput == RESTART_NUM) {
            return true;
        }
        return false;
    }

    public void exitGame() {

        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }
}
