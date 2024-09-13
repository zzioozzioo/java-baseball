package baseball.domain;

import baseball.view.InputView;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.NUM_LENGTH;
import static baseball.utility.Utility.toInt;

public class PlayerNumber {

    private final Set<Integer> playerNumber = new HashSet<>();

    public Set<Integer> getPlayerNumbers() {
        return playerNumber;
    }

    public void generatePlayerNumbers() {
        InputView inputView = new InputView();
        addPlayerNumbers(inputView.readPlayerNumbers());
        validateStringThreeNumberDuplicate();
    }

    public void addPlayerNumbers(String userInput) {
        IntStream.range(0, userInput.length())
                .map(i -> toInt(userInput.substring(i, i + 1)))
                .forEach(playerNumber::add);
    }

    /**
     * 유효성 검증
     */
    public void validateStringThreeNumberDuplicate() {

        validateThreeNumberDuplicate();
        validateThreeNumberRange();
    }

    public void validateThreeNumberDuplicate() {

        if (playerNumber.size() != NUM_LENGTH) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }
    }

    public void validateThreeNumberRange() {

        if (!playerNumber.stream().allMatch(digit -> Range.FIRST_RANGE.getNumber() <= digit && Range.LAST_RANGE.getNumber() >= digit)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

}
