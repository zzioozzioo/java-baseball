package baseball.constant;

import baseball.domain.GameCommand;

import static baseball.domain.GameCommand.RESTART_NUM;

public final class ConstMessage {

    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";

    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요: ";

    public static final String VALIDATE_NUMBER_LENGTH_MESSAGE = "숫자의 개수가 맞지 않습니다. 애플리케이션을 종료합니다.";

    public static final String VALIDATE_NUMBER_RANGE_MESSAGE = "숫자가 범위에 맞지 않습니다. 애플리케이션을 종료합니다.";

    public static final String VALIDATE_NUMBER_DUPLICATE_MESSAGE = "숫자가 중복되었습니다. 애플리케이션을 종료합니다.";

    public static final String VALIDATE_ONE_OR_TWO_IS_DIGIT_MESSAGE = "숫자가 아닙니다. 애플리케이션을 종료합니다.";

    public static final String VALIDATE_ONE_OR_TWO_WRONG_NUM_MESSAGE = "옳지 않은 숫자입니다. 애플리케이션을 종료합니다.";

    public static final String NOTHING = "낫싱";

    public static final String STRIKE = "스트라이크";

    public static final String BALL = "볼";

    public static final String SUCCESS_MESSAGE = ConstNumber.NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String CHOOSE_RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 " + GameCommand.RESTART_NUM + ", 종료하려면 " + GameCommand.EXIT_NUM + "를 입력하세요.";

}
