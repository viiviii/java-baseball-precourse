package baseball.gamePlay;

public final class Score {
    private final int strikeCount;
    private final int ballCount;

    public Score(int strikeCount, int ballCount) {
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
