package baseball;


import java.util.ArrayList;
import java.util.List;

import baseball.util.*;
import baseball.validation.Validator;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    private final Computer computer = new Computer();
    private final User user = new User();
    private final GameResult gameResult = new GameResult();
    private final Validator validation = new Validator();
    private final Format format = new Format();

    public BaseballGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void startGame() {

        while (true) {
            // 게임 한 라운드 진행
            playOneRound();

            // 게임 재시작 여부 체크
            if (!restartGame()) {
                return;
            }
        }
    }

    private void playOneRound() {

        List<Integer> randomComputerNumberList = computer.getRandomComputerNumbers();

        while (true) {
            List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

            System.out.println(INPUT_NUMBER_MESSAGE);

            playerNumberList = user.getPlayerNumbers(playerNumberList);

            // 게임 스코어 계산
            int strike = gameResult.countStrike(randomComputerNumberList, playerNumberList);
            int ball = gameResult.countBall(randomComputerNumberList, playerNumberList);

            if (gameResult.isGameSuccess(strike, ball)) {
                break;
            }
        }
    }

    public boolean restartGame() {
        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        String userInput = readLine();
        validation.validateOneOrTwo(userInput);

        int integerUserInput = format.toInt(userInput);

        if (integerUserInput == RESTART_NUM) {
            return true;
        }
        return false;
    }


}
