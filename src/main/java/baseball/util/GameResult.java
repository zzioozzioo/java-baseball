package baseball.util;

import java.util.List;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;

public class GameResult {

    public int countBall(List<Integer> randomComputerNumberList, List<Integer> playerNumberList) {
        int ball = 0;
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (isDigitBall(randomComputerNumberList, playerNumberList, i)) {
                ball++;
            }
        }
        return ball;
    }

    public boolean isDigitBall(List<Integer> randomComputerNumberList, List<Integer> playerNumberList, int index) {
        int randomComputerNumberDigit = randomComputerNumberList.get(index);
        int playerNumberDigit = playerNumberList.get(index);

        if (randomComputerNumberDigit != playerNumberDigit &&
                playerNumberList.contains(randomComputerNumberDigit) &&
                !isDigitStrike(randomComputerNumberList, playerNumberList, index)) {
            return true;
        }
        return false;
    }

    public boolean isGameSuccess(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
            return false;
        }
        if (strike == NUM_LENGTH) {
            System.out.println(NUM_LENGTH + STRIKE);
            System.out.println(SUCCESS_MESSAGE);
            return true;
        }
        System.out.println(ball + BALL + " " + strike + STRIKE);
        return false;
    }
}
