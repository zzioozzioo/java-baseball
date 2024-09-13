package baseball.view;

import baseball.domain.GameResult;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.NUM_LENGTH;

public class OutputView {

    public void startGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void inputNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public void restartGameMessage() {
        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);
    }

    public void printGameResult(GameResult result) {

        // TODO: if문을 바깥(client쪽)으로 밀어내기...
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (result.getStrike() == NUM_LENGTH) {
            System.out.println(NUM_LENGTH + STRIKE);
            System.out.println(SUCCESS_MESSAGE);
            return;
        }
        System.out.println(result.getBall() + BALL + " " + result.getStrike() + STRIKE);
    }
}
