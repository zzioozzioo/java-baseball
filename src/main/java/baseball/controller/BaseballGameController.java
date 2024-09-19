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
        getGameResult(randomNumber);
    }

    public RandomNumber getRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.generateRandomNumbers();
        return randomNumber;
    }

    public void getGameResult(RandomNumber randomNumber) {
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
        BallChecker ballChecker = new BallChecker(randomNumbers);
        Ball ball = new Ball(ballChecker);

        // TODO: 스트라이크 <-> 볼 잘못 인식하는 오류 발생

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
