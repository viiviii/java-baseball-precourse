package baseball.domain;

public final class Scores {
    private final int strikeCount;
    private final int ballCount;

    public Scores(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
