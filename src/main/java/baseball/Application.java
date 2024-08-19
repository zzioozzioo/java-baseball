package baseball;


import java.util.ArrayList;
import java.util.List;

import static baseball.util.Computer.*;
import static baseball.util.GameResult.*;
import static baseball.util.User.*;
import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;



public class Application {
    public static void main(String[] args) {

        // TODO: 코드를 성격별로 분류해야 하는데, 어떻게 설계하면 좋을까
        // TODO: restartGame() 어디로 보내야 할지 고민
        //  -> GameResult 클래스의 성격과는 맞지 않는 것 같음
        // TODO: 에러 메시지 더 상세하게 작성하기(나중에)

        System.out.println(START_GAME_MESSAGE);

        while (true) {

            List<Integer> randomComputerNumberList = getRandomComputerNumbers();

            while (true) {
                List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

                System.out.println(INPUT_NUMBER_MESSAGE);

                playerNumberList = getPlayerNumbers(playerNumberList);

                int strike = countStrike(randomComputerNumberList, playerNumberList);
                int ball = countBall(randomComputerNumberList, playerNumberList);

                if (isGameSuccess(strike, ball)) {
                    break;
                }
            }
            if (!restartGame()) {
                return;
            }
        }
    }
}