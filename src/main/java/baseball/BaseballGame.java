package baseball;


import java.util.List;

import baseball.domain.RandomNumber;
import baseball.util.Converter;
import baseball.util.GameResult;
import baseball.util.PlayerNumber;
import baseball.validation.Validator;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    private final GameResult gameResult = new GameResult();
    private final Validator validator = new Validator();
    private final Converter converter = new Converter();

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
        randomNumber.generateRandomNumber();

        PlayerNumber playerNumber = new PlayerNumber();

        while (true) {
            System.out.println(INPUT_NUMBER_MESSAGE);

            playerNumber.generatePlayerNumbers();

            if (scoreGame(randomNumber.getRandomNumber(), playerNumber.getPlayerNumbers()))
                break;
        }
    }

    private boolean scoreGame(List<Integer> randomComputerNumberList, List<Integer> playerNumberList) {

        int strike = gameResult.countStrike(randomComputerNumberList, playerNumberList);
        int ball = gameResult.countBall(randomComputerNumberList, playerNumberList);

        if (gameResult.isGameSuccess(strike, ball)) {
            return true;
        }
        return false;
    }

    public boolean restartGame() {

        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        String userInput = readLine();
        validator.validateOneOrTwo(userInput);

        int integerUserInput = converter.toInt(userInput);

        if (integerUserInput == RESTART_NUM) {
            return true;
        }
        return false;
    }


}
