package baseball;


import java.util.ArrayList;
import java.util.List;

import baseball.util.*;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;

public class BaseballGame {

    private final Computer computer = new Computer();
    private final User user = new User();
    private final GameResult gameResult = new GameResult();
    private final GameController gameController = new GameController();

    public BaseballGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void startGame() {

        while (true) {

            // 게임 한 라운드 진행
            playOneRound();

            // 게임 재시작 여부 체크
            if (!gameController.restartGame()) {
                return;
            }
        }
    }

    private void playOneRound() {
        // 컴퓨터에서 랜덤 숫자 생성
        List<Integer> randomComputerNumberList = computer.getRandomComputerNumbers();

        while (true) {
            // 사용자 랜덤 숫자 생성
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


}
