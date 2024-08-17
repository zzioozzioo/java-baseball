package baseball.validation;

import java.util.List;

import static baseball.constant.ConstMessage.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE;
import static baseball.constant.ConstNumber.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValidation {

    public static void validateStringThreeNumberDuplicate(List<Integer> playerNumberList) {

        validateThreeNumberLength(playerNumberList);
        validateThreeNaturalNumber(playerNumberList);
        validateThreeNumberDuplicate(playerNumberList);
    }

    public static void validateThreeNumberLength(List<Integer> playerNumberList) {

        if (playerNumberList.size() != NUM_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateThreeNaturalNumber(List<Integer> playerNumberList) {

        if (!playerNumberList.stream().allMatch(digit -> FIRST_RANGE <= digit && LAST_RANGE >= digit)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateThreeNumberDuplicate(List<Integer> playerNumberList) {

        if (playerNumberList.stream().distinct().count() != playerNumberList.size()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

}
