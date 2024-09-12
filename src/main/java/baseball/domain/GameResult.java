package baseball.domain;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;

public class GameResult {

    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void isGameSuccess(int strike, int ball) {
        // TODO: 결과 출력은 output에서,,

        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
            isSuccess = false;
        }
        if (strike == NUM_LENGTH) {
            System.out.println(NUM_LENGTH + STRIKE);
            System.out.println(SUCCESS_MESSAGE);
            isSuccess = true;
        }
        System.out.println(ball + BALL + " " + strike + STRIKE);
        isSuccess = false;
    }
}
