package baseball.util;

import baseball.domain.Range;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.NUM_LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayerNumber {

    private final Set<Integer> playerNumber = new HashSet<>();

    public Set<Integer> getPlayerNumbers() {
        return playerNumber;
    }

    public void generatePlayerNumbers() {
        String userInput = readLine();

        addPlayerNumbers(userInput);
        validateStringThreeNumberDuplicate();
    }

    public void addPlayerNumbers(String userInput) {
        IntStream.range(0, userInput.length())
                .map(i -> toInt(userInput.substring(i, i + 1)))
                .forEach(playerNuㅎmber::add);
    }

    public int toInt(String targetString) {
        return Integer.parseInt(targetString);
    }

    /**
     * 유효성 검증
     */
    public void validateStringThreeNumberDuplicate() {

        validateThreeNumberLength();
        validateThreeNumberRange();
        validateThreeNumberDuplicate();
    }

    public void validateThreeNumberLength() {

        if (playerNumber.size() != NUM_LENGTH) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_LENGTH_MESSAGE);
        }
    }

    public void validateThreeNumberRange() {

        if (!playerNumber.stream().allMatch(digit -> Range.FIRST_RANGE.getNumber() <= digit && Range.LAST_RANGE.getNumber() >= digit)) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_RANGE_MESSAGE);
        }
    }

    public void validateThreeNumberDuplicate() {

        if (playerNumber.stream().distinct().count() != playerNumber.size()) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_DUPLICATE_MESSAGE);
        }
    }

}
