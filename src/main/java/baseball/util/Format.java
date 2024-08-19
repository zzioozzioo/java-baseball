package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.ConstNumber.*;

public class Format {

    public static int StringToInt(String targetString) {
        return Integer.parseInt(targetString);
    }

    public static List<Integer> playerNumberStringToList(String userInput) {
        List<Integer> playerNumberList = new ArrayList<>(NUM_LENGTH);

        for (int i = 0; i < NUM_LENGTH; i++) {
            String targetString = userInput.substring(i, i + 1);
            int num = StringToInt(targetString);
            playerNumberList.add(num);
        }

        return playerNumberList;
    }
}
