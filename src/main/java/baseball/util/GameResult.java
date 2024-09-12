package baseball.util;

import java.util.List;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;

public class GameResult {

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
