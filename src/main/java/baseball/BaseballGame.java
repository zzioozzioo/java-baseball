package baseball;


import java.util.ArrayList;
import java.util.List;

import baseball.util.Computer;
import baseball.util.Converter;
import baseball.util.GameResult;
import baseball.util.Player;
import baseball.validation.Validator;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    private final Computer computer = new Computer();
    private final Player player = new Player();
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

        List<Integer> randomComputerNumberList = computer.getRandomComputerNumbers();

        while (true) {
            List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

            System.out.println(INPUT_NUMBER_MESSAGE);

            playerNumberList = player.getPlayerNumbers(playerNumberList);

            if (scoreGame(randomComputerNumberList, playerNumberList))
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
