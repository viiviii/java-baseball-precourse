package baseball.model;

public enum Hint {
    STRIKE, BALL, NOTHING;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
