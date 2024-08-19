# ⚾️ 숫자 야구 구현 기능 목록 ⚾️
***
## 1️⃣ 게임 시작 문구 출력 기능
- **startGame** 메서드 구현
  - Application의 main()을 실행하면 BaseballGame 객체를 생성
  - 생성된 객체가 해당 메서드를 호출

## 2️⃣ 컴퓨터 숫자 생성 기능
- **getRandomComputerNumbers** 메서드 구현
    - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 메서드 활용
      - 범위를 지정해주면 범위 안에 있는 int형을 하나 반환
    - 선택한 숫자가 기존의 숫자와 중복이 아닌지 확인
    - randomComputerNumberList에 저장
      - 선택한 3개의 숫자를 리스트에 저장해 반환

## 3️⃣ 플레이어 정답 입력 기능
- **getPlayerNumbers** 메서드 구현
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
    - 선택한 3개의 숫자가 기존의 숫자와 중복이 아닌지 확인
        - **validateStringThreeNumberDuplicate** 메서드 구현
          - 사용자 입력값이 1~9 사이의 서로 다른 세자리 숫자인지 여부 확인
          - **validateThreeNumberLength** 메서드 구현
            - 문자열의 길이가 3이 맞는지 확인
            - 잘못된 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
          - **validateThreeNaturalNumber** 메서드 구현
            - 문자열이 자연수로 이루어져 있는지 확인
            - 잘못된 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
          - **validateThreeNumberDuplicate** 메서드 구현
            - 3개의 숫자가 모두 다른지 확인
            - 잘못된 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
    - **playerNumberStringToInt** 메서드 구현
      - 문자열을 입력받아 세개의 정수(각 자릿수)를 요소로 하는 리스트 반환
      - playerNumberList에 저장

## 4️⃣ 스트라이크 개수 확인 기능
- **countStrike** 메서드 구현
  - randomComputerNumberList와 playerNumberList를 매개변수로 받아 strike 개수를 반환
  - strike의 개수를 count
    - **isDigitStrike** 메서드 구현
      - randomComputerNumberList, playerNumberList, 자릿수 인덱스 값을 매개변수로 받아 두 리스트의 인덱스 값에 해당하는 숫자가 같다면 true를 반환
      - 다르다면 false 반환

## 5️⃣ 볼 개수 확인 기능
- **countBall** 메서드 구현
  - randomNumberList와 playerNumberList를 매개변수로 받아 ball 개수를 반환
  - ball의 개수를 count
    - **isDigitBall** 메서드 구현
      - randomComputerNumberList, playerNumberList, 자릿수 인덱스 값을 매개변수로 받아 randomComputerNumberList의 인덱스 값에 해당하는 숫자가 playerNumberList의 다른 인덱스 주소에 존재한다면 true를 반환
      - 존재하지 않는다면 false 반환
      - isDigitStrike 메서드에서 true가 반환된다면 isDigitBall이 false를 반환하며 메서드 종료 

## 6️⃣ 플레이 결과 출력 기능
- **isGameSuccess** 메서드 구현
  - countStrike의 반환값인 스트라이크 개수와 countBall의 반환값인 볼 개수를 매개변수로 받아 플레이 결과를 볼, 스트라이크 개수로 표시
    - 볼과 스트라이크가 있는 경우 "{countBall}볼 {countStrike}스트라이크" 출력
    - 하나도 없는 경우 "낫싱" 출력
    - 3개의 숫자를 모두 맞힐 경우 "3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력

## 7️⃣ 게임 종료 기능
- **exitGame** 메서드 구현
  - 플레이어 정답 입력 기능에서 예외 발생
    - 사용자가 잘못된 값을 입력해 `IllegalArgumentException` 예외가 발생되는 경우
  - 게임 재시작 / 프로그램 종료 선택 기능에서 예외 발생
    - 사용자가 잘못된 값을 입력해 `IllegalArgumentException` 예외가 발생되는 경우

## 8️⃣ 게임 재시작 / 프로그램 종료 선택 기능
- **restartGame** 메서드 구현
  - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 문구를 출력하며 사용자 입력 받기
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
    - **validateOneOrTwo** 메서드 구현
      - 사용자가 잘못된 값(1 또는 2가 아닌 값)을 입력할 경우 exitGame()를 호출해 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
    - 사용자의 입력이 1이면 다시 게임을 시작하고, 2이면 프로그램을 완전히 종료

## 9️⃣ 예외 처리 기능
- 사용자 입력값 유효성 검사
  - 플레이어 정답 입력 기능의 getPlayerNumber 메서드에서
    - 사용자 입력값이 1~9 사이의 서로 다른 세자리 숫자가 아닌 경우 exitGame()를 호출해 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
        - 입력값이 세자리 이하, 이상인 경우
        - 입력된 세자리 숫자의 각 자릿수 중 중복이 있는 경우
        - 입력값이 자연수로 이루어져 있지 않은 경우
        - 아무것도 입력하지 않은 경우
  - 게임 재시작 / 프로그램 종료 선택 기능의 restartGame 메서드에서
    - 사용자 입력값이 1 또는 2가 아닌 경우 exitGame()를 호출해 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
      - 입력값이 1 또는 2 이외의 값인 경우
      - 입력값이 숫자가 아닌 경우
      - 아무것도 입력하지 않은 경우