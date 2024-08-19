package baseball;


import java.util.ArrayList;
import java.util.List;

import static baseball.util.Computer.*;
import static baseball.util.GameResult.*;
import static baseball.util.User.*;
import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;



public class Application {
    public static void main(String[] args) {

        // TODO: 코드를 성격별로 분류해야 하는데, 어떻게 설계하면 좋을까
        // TODO: Application은 단지 Baseball 클래스의 객체를 생성, 호출해 게임을 시작하도록 하는 기능
        //  Baseball에서 아래의 코드 실행하기
        // TODO: 에러 메시지 더 상세하게 작성하기(나중에)


        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startGame();
    }
}