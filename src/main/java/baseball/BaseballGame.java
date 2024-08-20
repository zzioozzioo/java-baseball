package baseball;


import java.util.ArrayList;
import java.util.List;

import baseball.util.*;
import baseball.validation.InputValidation;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;
import static camp.nextstep.edu.missionutils.Console.*;

public class BaseballGame {

    private final Computer computer = new Computer();
    private final User user = new User();
    private final GameResult gameResult = new GameResult();
    private final GameController gameController = new GameController();

    public BaseballGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void startGame() {

        // TODO: 이 메서드에서 더 추출할 부분이 없는지 고민
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
            if (!gameController.restartGame()) {
                return;
            }
        }
    }



}
