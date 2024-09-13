package baseball.domain;

import baseball.view.InputView;

import static baseball.constant.ConstMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameCommand {

    public static final int RESTART_NUM = 1;
    public static final int EXIT_NUM = 2;

    private int number;
    public int getNumber() {
        return number;
    }

    public void generateGameCommand() {

        InputView inputView = new InputView();
        String userInput = inputView.readGameCommand();
        validateOneOrTwo(userInput);
        this.number = toInt(userInput);
    }

    public int toInt(String targetString) {
        return Integer.parseInt(targetString);
    }

    public void validateOneOrTwo(String userInput) {
        int integerUserInput = toInt(userInput);
        if (integerUserInput != RESTART_NUM && integerUserInput != EXIT_NUM) {
            throw new IllegalArgumentException(INVALID_NUMBER_ONE_OR_TWO);
        }
    }

}
