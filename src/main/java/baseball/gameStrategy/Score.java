package baseball.gameStrategy;

public final class Score {
    private int strikeCount;
    private int ballCount;

    public Score(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Score init() {
        return new Score(0, 0);
    }

    void increase(Match match) {
        if (match.isStrike()) {
            strikeCount += 1;
        }
        if (match.isBall()) {
            ballCount += 1;
        }
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
