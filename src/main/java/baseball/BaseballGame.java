package baseball;


import java.util.Set;

import baseball.domain.GameCommand;
import baseball.domain.RandomNumber;
import baseball.domain.Strike;
import baseball.util.GameResult;
import baseball.domain.PlayerNumber;

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
        strike.countStrike(randomNumbers, playerNumbers);
        int ball = gameResult.countBall(randomComputerNumberList, playerNumberList);

        if (gameResult.isGameSuccess(strike.getStrike(), ball)) {
            return true;
        }
        return false;
    }

    public boolean restartGame() {

        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        GameCommand gameCommand = new GameCommand();
        gameCommand.generateGameCommand();

        return gameCommand.getNumber() == GameCommand.RESTART_NUM;
    }


}
