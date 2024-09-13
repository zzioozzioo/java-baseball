package baseball;


import java.util.Set;

import baseball.domain.*;
import baseball.domain.GameResult;
import baseball.view.OutputView;

import static baseball.constant.ConstMessage.*;

public class BaseballGame {

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

        do {
            System.out.println(INPUT_NUMBER_MESSAGE);

            playerNumber.generatePlayerNumbers();

        } while (!scoreGame(randomNumber.getRandomNumbers(), playerNumber.getPlayerNumbers()));
    }

    private boolean scoreGame(Set<Integer> randomNumbers, Set<Integer> playerNumbers) {

        StrikeChecker strikeChecker = new StrikeChecker();
        Strike strike = new Strike(strikeChecker);

        BallChecker ballChecker = new BallChecker(strikeChecker);
        Ball ball = new Ball(ballChecker);

        GameResult gameResult = new GameResult();
        OutputView outputView = new OutputView();

        strike.countStrike(randomNumbers, playerNumbers);
        ball.countBall(randomNumbers, playerNumbers, strike);

        gameResult.isGameSuccess(strike.getStrike(), ball.getBall());
        outputView.printGameResult(gameResult);

        return gameResult.isSuccess();
    }

    public boolean restartGame() {

        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        GameCommand gameCommand = new GameCommand();
        gameCommand.generateGameCommand();

        return gameCommand.getNumber() == GameCommand.RESTART_NUM;
    }


}
