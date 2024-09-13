package baseball.domain;

public enum Range {
    FIRST_RANGE(1),
    LAST_RANGE(9);

    private final int number;

    Range(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
