package baseball;


import java.util.Set;

import baseball.domain.*;
import baseball.domain.GameResult;
import baseball.view.OutputView;

public class BaseballGame {

    OutputView outputView = new OutputView();

    public BaseballGame() {
        outputView.startGameMessage();
    }

    public void startGame() {

        while (true) {

            playOneRound();

            if (!restartGame()) {
                return;
            }
        }
    }

    public void playOneRound() {
        RandomNumber randomNumber = getRandomNumber();
        getPlayerNumber(randomNumber);
    }

    public void getPlayerNumber(RandomNumber randomNumber) {
        PlayerNumber playerNumber = new PlayerNumber();
        do {
            outputView.inputNumberMessage();
            playerNumber.generatePlayerNumbers();

        } while (!scoreGame(randomNumber.getRandomNumbers(), playerNumber.getPlayerNumbers()));
    }

    public RandomNumber getRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.generateRandomNumbers();
        return randomNumber;
    }

    public boolean scoreGame(Set<Integer> randomNumbers, Set<Integer> playerNumbers) {

        // TODO: 메서드 기능 분리. 너무 길다!!

        StrikeChecker strikeChecker = new StrikeChecker();
        Strike strike = new Strike(strikeChecker);

        BallChecker ballChecker = new BallChecker(strikeChecker);
        Ball ball = new Ball(ballChecker);

        GameResult gameResult = new GameResult();

        strike.countStrike(randomNumbers, playerNumbers);
        ball.countBall(randomNumbers, playerNumbers, strike);

        gameResult.isGameSuccess(strike.getStrike(), ball.getBall());
        outputView.printGameResult(gameResult);

        return gameResult.isSuccess();
    }

    public boolean restartGame() {
        outputView.restartGameMessage();

        GameCommand gameCommand = new GameCommand();
        gameCommand.generateGameCommand();

        return gameCommand.getNumber() == GameCommand.RESTART_NUM;
    }


}
