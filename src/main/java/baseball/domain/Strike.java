package baseball.domain;

import java.util.Set;

import static baseball.constant.ConstNumber.NUM_LENGTH;

public class Strike {
    private int strike;

    public int getStrike() {
        return strike;
    }

    public void countStrike(Set<Integer> randomNumbers, Set<Integer> playerNumbers) {
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (isDigitStrike(randomNumbers, playerNumbers, i)) {
                strike++;
            }
        }
    }

    public boolean isDigitStrike(Set<Integer> randomNumbers, Set<Integer> playerNumbers, int i) {
        // TODO: get 말고 iterator로 모든 원소 검사하기
        int randomNumberDigit = randomNumbers.get(i);
        int playerNumberDigit = playerNumbers.get(i);

        return randomNumberDigit == playerNumberDigit;
    }

}
