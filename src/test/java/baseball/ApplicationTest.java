package baseball;

import baseball.domain.*;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.constant.ConstMessage.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    @DisplayName("플레이어 정답 입력값_값 존재 테스트")
    void PlayerNumbersHasValue() {
        //given
        InputView inputView = new InputView();
        String nonEmptyString = "123";
        String emptyString = "";

        //when & then
        assertThatCode(() -> inputView.validateHasValue(nonEmptyString))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> inputView.validateHasValue(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NUMBER_MESSAGE);

    }

    @Test
    @DisplayName("플레이어 정답 입력값_숫자 여부 테스트")
    void ArePlayerNumbersNumeric() {
        //given
        InputView inputView = new InputView();
        String numericString = "123";
        String nonNumericString = "abc";

        //when & then
        assertThatCode(() -> inputView.validateIsNumeric(numericString))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> inputView.validateIsNumeric(nonNumericString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_NUMBER);
    }

    @Test
    @DisplayName("플레이어 정답 입력값_길이 테스트")
    void PlayerNumbersLength() {
        //given
        InputView inputView = new InputView();
        String validLengthString = "123";
        String invalidLengthString = "1234";

        //when & then
        assertThatCode(() -> inputView.validatePlayerNumbersLength(validLengthString))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> inputView.validatePlayerNumbersLength(invalidLengthString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_LENGTH);

    }

    @Test
    @DisplayName("플레이어 정답 입력값_중복 테스트")
    void ArePlayerNumbersDuplicated() {
        //given
        PlayerNumber validPlayerNumber = new PlayerNumber();
        validPlayerNumber.addPlayerNumbers("123");

        //when & then
        assertThatCode(validPlayerNumber::validateThreeNumberDuplicate)
                .doesNotThrowAnyException();

        //given
        PlayerNumber invalidPlayerNumber = new PlayerNumber();
        invalidPlayerNumber.addPlayerNumbers("122");

        //when & then
        assertThatThrownBy(invalidPlayerNumber::validateThreeNumberDuplicate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_DUPLICATED);
    }

    @Test
    @DisplayName("플레이어 정답 입력값_범위 테스트")
    void PlayerNumbersInRange() {
        //given
        PlayerNumber validPlayerNumber = new PlayerNumber();
        validPlayerNumber.addPlayerNumbers("123");

        //when & then
        assertThatCode(validPlayerNumber::validateThreeNumberRange)
                .doesNotThrowAnyException();

        //given
        PlayerNumber invalidPlayerNumber = new PlayerNumber();
        invalidPlayerNumber.addPlayerNumbers("120");

        assertThatThrownBy(invalidPlayerNumber::validateThreeNumberRange)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_RANGE);
    }

    @Test
    @DisplayName("재시작/종료 선택 입력값_값 존재 테스트")
    void GameCommandHasValue() {
        //given
        InputView inputView = new InputView();
        String nonEmptyString = "1";
        String emptyString = "";

        //when & then
        assertThatCode(() -> inputView.validateHasValue(nonEmptyString))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> inputView.validateHasValue(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NUMBER_MESSAGE);
    }

    @Test
    @DisplayName("재시작/종료 선택 입력값_숫자 여부 테스트")
    void IsGameCommandNumeric() {
        //given
        InputView inputView = new InputView();
        String numericString = "1";
        String nonNumericString = "ㄱㄴㄷ";

        //when & then
        assertThatCode(() -> inputView.validateIsNumeric(numericString))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> inputView.validateIsNumeric(nonNumericString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_NUMBER);
    }

    @Test
    @DisplayName("재시작/종료 선택 입력값_길이 테스트")
    void GameCommandLength() {
        //given
        InputView inputView = new InputView();
        String validLengthString = "1";
        String invalidLengthString = "12";

        //when & then
        assertThatCode(() -> inputView.validateGameCommandLength(validLengthString))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> inputView.validateGameCommandLength(invalidLengthString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_LENGTH);

    }

    @Test
    @DisplayName("재시작/종료 선택 입력값_올바른 숫자 선택 여부 테스트")
    void GameCommandOneOrTwo() {
        //given
        GameCommand gameCommand = new GameCommand();
        String validString1 = "1";
        String validString2 = "2";
        String invalidString = "3";

        //when & then
        assertThatCode(() -> gameCommand.validateOneOrTwo(validString1))
                .doesNotThrowAnyException();

        assertThatCode(() -> gameCommand.validateOneOrTwo(validString2))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> gameCommand.validateOneOrTwo(invalidString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_ONE_OR_TWO);
    }

    @Test
    @DisplayName("스트라이크 개수 세기 테스트")
    void CountStrike() {
        //given
        Set<Integer> randomNumbers = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> playerNumbers = new LinkedHashSet<>(Arrays.asList(1, 2, 4));

        StrikeChecker checker = new StrikeChecker();
        Strike strike = new Strike(checker);

        //when
        strike.countStrike(randomNumbers, playerNumbers);

        //then
        assertEquals(2, strike.getStrike());
    }

    @Test
    @DisplayName("볼 개수 세기 테스트")
    void CountBall() {
        //given
        Set<Integer> randomNumbers = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> playerNumbers = new LinkedHashSet<>(Arrays.asList(2, 1, 4));

        BallChecker checker = new BallChecker(randomNumbers);
        Ball ball = new Ball(checker);

        //when
        ball.countBall(randomNumbers, playerNumbers);

        //then
        assertEquals(2, ball.getBall());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
