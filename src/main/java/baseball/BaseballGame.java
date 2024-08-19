package baseball;


import java.util.ArrayList;
import java.util.List;

import baseball.util.Computer;
import baseball.util.GameResult;
import baseball.util.User;
import baseball.validation.InputValidation;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;
import static baseball.util.Format.StringToInt;
import static baseball.validation.InputValidation.*;
import static camp.nextstep.edu.missionutils.Console.*;

public class BaseballGame {

    private final Computer computer = new Computer();
    private final User user = new User();
    private final GameResult gameResult = new GameResult();
    private final InputValidation validation = new InputValidation();

    public BaseballGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void startGame() {
        while (true) {

            List<Integer> randomComputerNumberList = computer.getRandomComputerNumbers();

            while (true) {
                List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

                System.out.println(INPUT_NUMBER_MESSAGE);

                playerNumberList = user.getPlayerNumbers(playerNumberList);

                int strike = gameResult.countStrike(randomComputerNumberList, playerNumberList);
                int ball = gameResult.countBall(randomComputerNumberList, playerNumberList);

                if (gameResult.isGameSuccess(strike, ball)) {
                    break;
                }
            }
            if (!restartGame()) {
                return;
            }
        }
    }

    public boolean restartGame() {
        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        String userInput = readLine();
        validation.validateOneOrTwo(userInput);

        int integerUserInput = StringToInt(userInput);

        if (integerUserInput == RESTART_NUM) {
            return true;
        }
        return false;
    }

}
