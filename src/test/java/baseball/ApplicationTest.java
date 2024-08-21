package baseball;

import baseball.util.Converter;
import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.constant.ConstMessage.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("문자열에서 정수 리스트로 변환 테스트")
    void StringToInt() throws Exception {
        //given
        Converter converter = new Converter();
        String inputString = "123";

        //when
        List<Integer> inputList = converter.playerNumberToList(inputString);

        //then
        List<Integer> expectedList = List.of(1, 2, 3);
        assertThat(inputList).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("사용자 입력값 길이 테스트")
    void UserInputLength() throws Exception {
        //given
        Validator validator = new Validator();
        List<Integer> correctInputList = List.of(1, 2, 3);
        List<Integer> moreInputList = List.of(1, 2, 3, 4);
        List<Integer> lessInputList = List.of(1, 2);

        //when & then
        assertThatCode(() -> validator.validateThreeNumberLength(correctInputList))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> validator.validateThreeNumberLength(moreInputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);

        assertThatThrownBy(() -> validator.validateThreeNumberLength(lessInputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("사용자 입력값 범위 테스트")
    void UserInputRange() throws Exception {
        //given
        Validator validator = new Validator();
        List<Integer> correctInputList = List.of(1, 2, 3);
        List<Integer> outOfRangeInputList = List.of(0, 1, 2);

        //when & then
        assertThatCode(() -> validator.validateThreeNumberRange(correctInputList))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> validator.validateThreeNumberRange(outOfRangeInputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("사용자 입력값 중복 테스트")
    void UserInputDuplicate() throws Exception {
        //given
        Validator validator = new Validator();
        List<Integer> correctInputList = List.of(1, 2, 3);
        List<Integer> duplicatedInputList = List.of(1, 2, 2);

        //when & then
        assertThatCode(() -> validator.validateThreeNumberDuplicate(correctInputList))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> validator.validateThreeNumberDuplicate(duplicatedInputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("재시작 혹은 종료 선택 입력값 숫자 여부 테스트")
    void RestartNumber_isDigit() throws Exception {
        //given
        Validator validator = new Validator();
        String correctInputString = "1";
        String wrongInputString = "d";

        //when & then
        assertThatCode(() -> validator.validateOneOrTwo(correctInputString))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> validator.validateOneOrTwo(wrongInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("재시작 혹은 종료 선택 입력값 올바른 숫자 선택 여부 테스트")
    void RestartNumber_isOneOrTwo() throws Exception {
        //given
        Validator validator = new Validator();
        String correctInputString1 = "1";
        String correctInputString2 = "2";
        String wrongInputString = "3";

        //when & then
        assertThatCode(() -> validator.validateOneOrTwo(correctInputString1))
                .doesNotThrowAnyException();

        assertThatCode(() -> validator.validateOneOrTwo(correctInputString2))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> validator.validateOneOrTwo(wrongInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    // TODO: 빈칸 입력이어도 위에 있는 if문들에서 잡아주는데, 불필요하지 않나?
    @Test
    @DisplayName("재시작 혹은 종료 선택 입력값 빈칸 테스트")
    void RestartNumber_isBlank() throws Exception {
        //given
        Validator validator = new Validator();
        String correctInputString1 = "1";
        String wrongInputString = " ";

        //when & then
        assertThatCode(() -> validator.validateOneOrTwo(correctInputString1))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> validator.validateOneOrTwo(wrongInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
