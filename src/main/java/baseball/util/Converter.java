package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.ConstNumber.*;

public class Converter {

    // TODO: 이 class가 정말 필요한지 고민
    public int toInt(String targetString) {
        return Integer.parseInt(targetString);
    }

    public List<Integer> playerNumberToList(String userInput) {
        List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

        for (int i = 0; i < NUM_LENGTH; i++) {
            String targetString = userInput.substring(i, i + 1);
            int num = toInt(targetString);
            playerNumberList.add(num);
        }

        return playerNumberList;
    }
}
