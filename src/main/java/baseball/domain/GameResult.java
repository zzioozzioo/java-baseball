package baseball.domain;

import static baseball.constant.ConstNumber.*;

public class GameResult {

    private boolean isSuccess;

    private int strike;
    private int ball;

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void isGameSuccess(int strike, int ball) {

        this.strike = strike;
        this.ball = ball;

        if (strike == 0 && ball == 0) {
            isSuccess = false;
            return;
        }
        if (strike == NUM_LENGTH) {
            isSuccess = true;
            return;
        }
        isSuccess = false;
    }
}
