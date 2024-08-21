package baseball.util;

import baseball.validation.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    private final Validator validator = new Validator();
    private final Converter converter = new Converter();


    public List<Integer> getPlayerNumbers(List<Integer> playerNumberList) {
        String userInput = readLine();

        playerNumberList = converter.playerNumberToList(userInput);
        validator.validateStringThreeNumberDuplicate(playerNumberList);

        return playerNumberList;
    }
}
