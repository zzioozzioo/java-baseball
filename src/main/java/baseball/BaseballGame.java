package baseball;


import java.util.Set;

import baseball.domain.*;
import baseball.util.GameResult;

import static baseball.constant.ConstMessage.*;

public class BaseballGame {

    private final GameResult gameResult = new GameResult();

    public BaseballGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void startGame() {

        while (true) {

            playOneRound();

            if (!restartGame()) {
                return;
            }
        }
    }

    private void playOneRound() {

        RandomNumber randomNumber = new RandomNumber();
        randomNumber.generateRandomNumbers();

        PlayerNumber playerNumber = new PlayerNumber();

        while (true) {
            System.out.println(INPUT_NUMBER_MESSAGE);

            playerNumber.generatePlayerNumbers();

            if (scoreGame(randomNumber.getRandomNumbers(), playerNumber.getPlayerNumbers()))
                break;
        }
    }

    private boolean scoreGame(Set<Integer> randomNumbers, Set<Integer> playerNumbers) {

        Strike strike = new Strike();
        Ball ball = new Ball();
        strike.countStrike(randomNumbers, playerNumbers);
        ball.countBall(randomNumbers, playerNumbers, strike);

        return gameResult.isGameSuccess(strike.getStrike(), ball.getBall());
    }

    public boolean restartGame() {

        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        GameCommand gameCommand = new GameCommand();
        gameCommand.generateGameCommand();

        return gameCommand.getNumber() == GameCommand.RESTART_NUM;
    }


}
