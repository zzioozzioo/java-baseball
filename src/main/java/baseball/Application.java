package baseball;


import java.util.ArrayList;
import java.util.List;

import static baseball.validation.InputValidation.validateStringThreeNumberDuplicate;
import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

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

    private static List<Integer> getRandomComputerNumbers() {
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

    private static List<Integer> playerNumberStringToInt(String userInput) {
        List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

        for (int i = 0; i < NUM_LENGTH; i++) {
            int num = Integer.valueOf(userInput.substring(i, i + 1));
            playerNumberList.add(num);
        }

        return playerNumberList;
    }

    private static int countStrike(List<Integer> randomComputerNumberList, List<Integer> playerNumberList) {
        int strike = 0;
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (isDigitStrike(randomComputerNumberList, playerNumberList, i)) {
                strike++;
            }
        }
        return strike;
    }

    private static boolean isDigitStrike(List<Integer> randomComputerNumberList, List<Integer> playerNumberList, int index) {
        int randomComputerNumberDigit = randomComputerNumberList.get(index);
        int playerNumberDigit = playerNumberList.get(index);

        if (randomComputerNumberDigit == playerNumberDigit) {
            return true;
        }
        return false;
    }

    private static int countBall(List<Integer> randomComputerNumberList, List<Integer> playerNumberList) {
        int ball = 0;
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (isDigitBall(randomComputerNumberList, playerNumberList, i)) {
                ball++;
            }
        }
        return ball;
    }

    private static boolean isDigitBall(List<Integer> randomComputerNumberList, List<Integer> playerNumberList, int index) {
        int randomComputerNumberDigit = randomComputerNumberList.get(index);
        int playerNumberDigit = playerNumberList.get(index);

        if (randomComputerNumberDigit != playerNumberDigit &&
                playerNumberList.contains(randomComputerNumberDigit) &&
                !isDigitStrike(randomComputerNumberList, playerNumberList, index)) {
            return true;
        }
        return false;
    }

    private static boolean isGameSuccess(int strike, int ball) {
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

    private static boolean restartGame() {
        System.out.println(CHOOSE_RESTART_OR_EXIT_MESSAGE);

        String userInput = readLine();
        isOneOrTwo(userInput);

        // TODO: 굳이 정수로 변환해야 할 필요가 있을까? 예외는 모두 isOneOrTwo에서 처리할 텐데 그냥 바꿔서 써도 되지 않을까?
        int integerUserInput = Integer.valueOf(userInput);

        if (integerUserInput == RESTART_NUM) {
            return true;
        }
        return false;
    }

    // TODO: validation 패키지로 추출하기
    private static void isOneOrTwo(String userInput) {

        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
        // TODO: StringToInt 로직 중복 해결하기
        //  해당 메서드, playerNumberStringToInt 메서드
        int integerUserInput = Integer.valueOf(userInput);
        if (integerUserInput != RESTART_NUM && integerUserInput != EXIT_NUM) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }

    }
}