package baseball.util;

import baseball.validation.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class User {

    private final Validator validation = new Validator();
    private final Converter converter = new Converter();


    public List<Integer> getPlayerNumbers(List<Integer> playerNumberList) {
        String userInput = readLine();

        playerNumberList = converter.playerNumberToList(userInput);
        validation.validateStringThreeNumberDuplicate(playerNumberList);

        return playerNumberList;
    }
}
