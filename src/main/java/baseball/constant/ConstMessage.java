package baseball.constant;

import baseball.domain.GameCommand;

public final class ConstMessage {

    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";

    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요: ";

    public static final String INVALID_NUMBER_LENGTH = "숫자의 길이가 옳지 않습니다. 애플리케이션을 종료합니다.";

    public static final String NUMBER_DUPLICATED = "중복되지 않은 숫자 세 개를 입력해야 합니다. 애플리케이션을 종료합니다.";

    public static final String INVALID_NUMBER_RANGE = "숫자가 범위에 맞지 않습니다. 애플리케이션을 종료합니다.";

    public static final String IS_NOT_NUMBER = "숫자가 아닙니다. 애플리케이션을 종료합니다.";

    public static final String INVALID_NUMBER_ONE_OR_TWO = "옳지 않은 숫자입니다. 애플리케이션을 종료합니다.";

    public static final String NOTHING = "낫싱";

    public static final String STRIKE = "스트라이크";

    public static final String BALL = "볼";

    public static final String SUCCESS_MESSAGE = ConstNumber.NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String CHOOSE_RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 " + GameCommand.RESTART_NUM + ", 종료하려면 " + GameCommand.EXIT_NUM + "를 입력하세요.";

}
