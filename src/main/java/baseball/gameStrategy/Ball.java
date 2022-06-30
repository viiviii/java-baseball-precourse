package baseball.gameStrategy;

import java.util.Objects;

final class Ball {
    private final int position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BallNumber(number);
    }

    public Match matchOf(Ball other) {
        if (isStrike(other)) {
            return Match.STRIKE;
        }
        if (isBall(other)) {
            return Match.BALL;
        }
        return Match.NOTHING;
    }

    private boolean isStrike(Ball other) {
        return this.equals(other);
    }

    private boolean isBall(Ball other) {
        return !isStrike(other) && this.number.equals(other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && number.equals(ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
