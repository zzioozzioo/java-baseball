package baseball;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import static baseball.validation.InputValidation.*;

import static baseball.constant.ConstMessage.*;
import static baseball.constant.ConstNumber.*;


public class Application {
    public static void main(String[] args) {

        System.out.println(START_GAME_MESSAGE);

        // TODO: 코드 한 줄에 점(.) 하나만 허용
        // TODO: 메서드 인자 수 줄여보기(2개 이하로)
        // TODO: 기능별 커밋..? 기능별로 클래스를 다 분리하라는 말인 건가
        // TODO: 코드를 성격별로 분류해야 하는데, 어떻게 설계하면 좋을까
        // TODO: 에러 메시지 더 상세하게 작성하기

        while (true) {

            List<Integer> randomComputerNumberList = getRandomComputerNumbers();

            while (true) {
                List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

                System.out.println(INPUT_NUMBER_MESSAGE);

                playerNumberList = getPlayerNumbers(playerNumberList);

                int strike = countStrike(randomComputerNumberList, playerNumberList);
                int ball = countBall(randomComputerNumberList, playerNumberList);

                if (isGameSuccess(strike, ball)) { // true이면 게임 종료
                    break;
                }
            }
            if (!restartGame()) { // 재시작: true
                return;
            }
        }
    }

    public static List<Integer> getRandomComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_LENGTH) {
            int randomNumber = pickNumberInRange(FIRST_RANGE, LAST_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> getPlayerNumbers(List<Integer> playerNumberList) {
        String userInput = readLine();

        playerNumberList = playerNumberStringToInt(userInput);
        validateStringThreeNumberDuplicate(playerNumberList);

        return playerNumberList;
    }

    public static List<Integer> playerNumberStringToInt(String userInput) {
        List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

        for (int i = 0; i < NUM_LENGTH; i++) {
//            int num = Integer.valueOf(userInput.substring(i, i + 1));
            String substring = userInput.substring(i, i + 1);
            int num = StringToInt(substring);
            playerNumberList.add(num);
        }

        return playerNumberList;
    }



    public static int countStrike(List<Integer> randomComputerNumberList, List<Integer> playerNumberList) {
        int strike = 0;
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (isDigitStrike(randomComputerNumberList, playerNumberList, i)) {
                strike++;
            }
        }
        return strike;
    }

    public static boolean isDigitStrike(List<Integer> randomComputerNumberList, List<Integer> playerNumberList, int index) {
        int randomComputerNumberDigit = randomComputerNumberList.get(index);
        int playerNumberDigit = playerNumberList.get(index);

        if (randomComputerNumberDigit == playerNumberDigit) {
            return true;
        }
        return false;
    }

    public static int countBall(List<Integer> randomComputerNumberList, List<Integer> playerNumberList) {
        int ball = 0;
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (isDigitBall(randomComputerNumberList, playerNumberList, i)) {
                ball++;
            }
        }
        return ball;
    }

    public static boolean isDigitBall(List<Integer> randomComputerNumberList, List<Integer> playerNumberList, int index) {
        int randomComputerNumberDigit = randomComputerNumberList.get(index);
        int playerNumberDigit = playerNumberList.get(index);

        if (randomComputerNumberDigit != playerNumberDigit &&
                playerNumberList.contains(randomComputerNumberDigit) &&
                !isDigitStrike(randomComputerNumberList, playerNumberList, index)) {
            return true;
        }
        return false;
    }

    public static boolean isGameSuccess(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
            return false;
        }
        if (strike == NUM_LENGTH) {
            System.out.println(NUM_LENGTH + STRIKE);
            System.out.println(ALL_STRIKE_AND_EXIT_MESSAGE);
            return true;
        }
        System.out.println(ball + BALL + " " + strike + STRIKE);
        return false;
    }

    public static boolean restartGame() {
        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        String userInput = readLine();
        validateOneOrTwo(userInput);

        // TODO: 굳이 정수로 변환해야 할 필요가 있을까? 예외는 모두 isOneOrTwo에서 처리할 텐데 그냥 바꿔서 써도 되지 않을까?
        int integerUserInput = StringToInt(userInput);

        if (integerUserInput == RESTART_NUM) {
            return true;
        }
        return false;
    }

    public static int StringToInt(String substring) {
        int num = Integer.valueOf(substring);
        return num;
    }


}