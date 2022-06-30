package baseball.gameStrategy;

enum Match {
    STRIKE, BALL, NOTHING;

    boolean isStrike() {
        return this == STRIKE;
    }

    boolean isBall() {
        return this == BALL;
    }
}
