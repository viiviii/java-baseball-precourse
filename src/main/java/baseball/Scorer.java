package baseball;

public final class Scorer {

    public String scoreTo(Ball ball, Ball other) {
        if (isStrike(ball, other)) {
            return "스트라이크";
        }
        if (isBall(ball, other)) {
            return "볼";
        }
        return "낫싱";
    }

    public boolean isStrike(Ball ball, Ball other) {
        return ball.equals(other);
    }

    public boolean isBall(Ball ball, Ball other) {
        return !ball.equals(other) && ball.number() == other.number();
    }
}
