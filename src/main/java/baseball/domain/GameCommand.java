package baseball.domain;

import static baseball.constant.ConstMessage.VALIDATE_ONE_OR_TWO_IS_DIGIT_MESSAGE;
import static baseball.constant.ConstMessage.VALIDATE_ONE_OR_TWO_WRONG_NUM_MESSAGE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameCommand {

    public static final int RESTART_NUM = 1;
    public static final int EXIT_NUM = 2;

    private int number;
    public int getNumber() {
        return number;
    }

    public void generateGameCommand() {
        String userInput = readLine();
        validateOneOrTwo(userInput);

        this.number = toInt(userInput);
    }

    public int toInt(String targetString) {

        return Integer.parseInt(targetString);
    }

    public void validateOneOrTwo(String userInput) {
        isNumeric(userInput);
        isOneOrTwo(userInput);
    }

    public void isNumeric(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(VALIDATE_ONE_OR_TWO_IS_DIGIT_MESSAGE);
        }
    }

    public void isOneOrTwo(String userInput) {
        int integerUserInput = toInt(userInput);
        if (integerUserInput != RESTART_NUM && integerUserInput != EXIT_NUM) {
            throw new IllegalArgumentException(VALIDATE_ONE_OR_TWO_WRONG_NUM_MESSAGE);
        }
    }

}
