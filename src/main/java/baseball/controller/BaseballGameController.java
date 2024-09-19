package baseball.controller;


import java.util.Set;

import baseball.domain.*;
import baseball.view.OutputView;

public class BaseballGameController {

    OutputView outputView = new OutputView();

    public BaseballGameController() {
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

    public RandomNumber getRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.generateRandomNumbers();
        return randomNumber;
    }

    public void getPlayerNumber(RandomNumber randomNumber) {
        PlayerNumber playerNumber;
        do {
            playerNumber = new PlayerNumber();
            outputView.inputNumberMessage();
            playerNumber.generatePlayerNumbers();

        } while (!scoreGame(randomNumber.getRandomNumbers(), playerNumber.getPlayerNumbers()));
    }

    public boolean scoreGame(Set<Integer> randomNumbers, Set<Integer> playerNumbers) {
        StrikeChecker strikeChecker = new StrikeChecker();
        Strike strike = new Strike(strikeChecker);
        BallChecker ballChecker = new BallChecker(strikeChecker, playerNumbers);
        Ball ball = new Ball(ballChecker);

        strike.countStrike(randomNumbers, playerNumbers);
        ball.countBall(randomNumbers, playerNumbers);

        return generateGameResult(strike, ball);
    }

    public boolean generateGameResult(Strike strike, Ball ball) {
        GameResult gameResult = new GameResult();
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
