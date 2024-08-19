package baseball.util;

import baseball.validation.InputValidation;

import java.util.List;

import static baseball.util.Format.*;
import static baseball.validation.InputValidation.*;

import static camp.nextstep.edu.missionutils.Console.*;

public class User {

    private final InputValidation validation = new InputValidation();

    public List<Integer> getPlayerNumbers(List<Integer> playerNumberList) {
        String userInput = readLine();

        playerNumberList = playerNumberStringToList(userInput);
        validation.validateStringThreeNumberDuplicate(playerNumberList);

        return playerNumberList;
    }
}
