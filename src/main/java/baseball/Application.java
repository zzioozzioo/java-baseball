package baseball;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다");

        // TODO: 메서드 length, indent depth 확인하기
        // TODO: 숫자 상수화하기
        // TODO: 코드 한 줄에 점(.) 하나만 허용
        // TODO: 메서드 인자 수 줄여보기(2개 이하로)

        while (true) {

            List<Integer> randomComputerNumberList = new ArrayList<>();

            randomComputerNumberList = getRandomComputerNumbers();

            while (true) {
                List<Integer> playerNumberList = new ArrayList<>();

                System.out.println("숫자를 입력해주세요: ");
                playerNumberList = getPlayerNumbers();

                int strike = countStrike(randomComputerNumberList, playerNumberList);
                int ball = countBall(randomComputerNumberList, playerNumberList);

                if (printPlayResult(strike, ball)) { // true이면 게임 종료
                    break;
                }
            }
            if (!chooseRestartOrExit()) { // 재시작: true
                return;
            }
        }
    }

    private static List<Integer> getRandomComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> getPlayerNumbers() {
        String userInput = readLine();

        if(!validateStringThreeNumberDuplicate(userInput)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
        }

        return playerNumberStringToInt(userInput);
    }

    private static boolean validateStringThreeNumberDuplicate(String userInput) {

        int passException = 0;
        if (validateThreeNumberLength(userInput)) {
            passException++;
        }
        if (validateThreeNaturalNumber(userInput)) {
            passException++;
        }
        if (validateThreeNumberDuplicate(userInput)) {
            passException++;
        }

        if (passException == 3) { // 모든 예외 처리 통과
            return true;
        }
        return false;
    }

    private static boolean validateThreeNumberLength(String userInput) {

        if (userInput.length() == 3) {
            return true;
        }
        return false;
    }

    private static boolean validateThreeNaturalNumber(String userInput) {

        // TODO: 자연수 판별하는 더 좋은 방법 연구
        if (Integer.valueOf(userInput) > 0 && userInput.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }

    private static boolean validateThreeNumberDuplicate(String userInput) {

        // TODO: 세 숫자 중복 검사하는 더 좋은 방법 연구
        List<Integer> duplicateCheckList = new ArrayList<>();
        int index = 0;
        while (duplicateCheckList.size() < 3) {
            int targetNum = Character.getNumericValue(userInput.charAt(index));
            index++;
            if (duplicateCheckList.contains(targetNum)) {
                return false;
            }
            duplicateCheckList.add(targetNum);
        }
        return true;
    }

    private static List<Integer> playerNumberStringToInt(String userInput) {
        List<Integer> playerNumberList = new ArrayList<>(3);

        // TODO: stream으로 풀 수 있는지 연구
        for (int i = 0; i < 3; i++) {
            playerNumberList.add(Integer.valueOf(userInput.substring(i, i + 1)));
        }

        return playerNumberList;
    }

    private static int countStrike(List<Integer> randomComputerNumberList, List<Integer> playerNumberList) {
        int strike = 0;
        for(int i=0; i<randomComputerNumberList.size(); i++) {
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
        for (int i = 0; i < randomComputerNumberList.size(); i++) {
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

    // TODO: 메서드명 수정(반환값 boolean에 맞춰서 다시 고민)
    private static boolean printPlayResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
        return false;
    }

    // TODO: 메서드명 수정(반환값 boolean에 맞춰서 다시 고민)
    private static boolean chooseRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = readLine();
        if (!isOneOrTwo(userInput)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
        }

        // TODO: 굳이 정수로 변환해야 할 필요가 있을까? 예외는 모두 isOneOrTwo에서 처리할 텐데 그냥 바꿔서 써도 되지 않을까?
        int integerUserInput = Integer.valueOf(userInput);

        // restartGame() 어때?
        if (integerUserInput == 1) {
            return true;
        }
        return false;
    }

    private static boolean isOneOrTwo(String userInput) {

        int passException = 0;
        if (userInput.chars().allMatch(Character::isDigit)) {
            passException++;
        }
        // TODO: StringToInt 로직 중복 해결하기
        //  해당 메서드, chooseRestartOrExit 메서드, validateThreeNaturalNumber 메서드
        int integerUserInput = Integer.valueOf(userInput);
        if (integerUserInput == 1 || integerUserInput == 2) {
            passException++;
        }
        if (userInput != "") {
            passException++;
        }

        if (passException == 3) { // 모든 예외 처리 통과
            return true;
        }
        return false;
    }
}
