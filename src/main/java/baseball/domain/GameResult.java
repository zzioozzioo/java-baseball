package baseball.domain;

import static baseball.constant.ConstNumber.*;

public class GameResult {


    private int strike;
    private int ball;
    private boolean isSuccess;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void isGameSuccess(int strike, int ball) {

        this.strike = strike;
        this.ball = ball;

        isSuccess = (strike == NUM_LENGTH);
    }
}
