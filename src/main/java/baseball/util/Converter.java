package baseball.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.constant.ConstNumber.*;

public class Converter {

    // TODO: 이 class가 정말 필요한지 고민
    //  plyerNumberToList()는 User 클래스에 포함시켜도 무리가 없고,
    //  toInt()는 여러 클래스에서 사용하고 있는 메서드라 특정 클래스에 포함시키기에는 무리가 있다.
    //  playerNumberToList()를 User 클래스로 옮기자니 Converter 클래스에는 toInt()만 남게 되어 애매해짐
    //  그렇다고 정적 메서드로 사용하기에는 단점 1. 클래스간 강결합이 생김 2. OOP에 맞지 않음
    //  고민해보자...
    public int toInt(String targetString) {
        return Integer.parseInt(targetString);
    }

    public List<Integer> playerNumberToList(String userInput) {

        List<Integer> playerNumberList = IntStream.range(0, NUM_LENGTH)
                .mapToObj(i -> userInput.substring(i, i + 1))
                .map(this::toInt)
                .collect(Collectors.toList());

        return playerNumberList;
    }
}
