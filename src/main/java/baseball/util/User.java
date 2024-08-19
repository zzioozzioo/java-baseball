package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Format.*;
import static baseball.validation.InputValidation.*;

import static camp.nextstep.edu.missionutils.Console.*;

public class User {

    public static List<Integer> getPlayerNumbers(List<Integer> playerNumberList) {
        String userInput = readLine();

        playerNumberList = playerNumberStringToList(userInput);
        validateStringThreeNumberDuplicate(playerNumberList);

        return playerNumberList;
    }


}
