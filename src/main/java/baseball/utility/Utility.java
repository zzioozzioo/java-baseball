package baseball.utility;

public class Utility {

    public static int toInt(String targetString) {
        return Integer.parseInt(targetString);
    }

    public static boolean isEqual(int randomNumberDigit, int playerNumberDigit) {
        return randomNumberDigit == playerNumberDigit;
    }

}
