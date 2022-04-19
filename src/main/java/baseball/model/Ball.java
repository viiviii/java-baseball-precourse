package baseball.model;

import java.util.Objects;

public final class Ball {
    private final int position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BallNumber(number);
    }

    public Hint matchOf(Ball other) {
        if (this.equals(other)) {
            return Hint.STRIKE;
        }
        if (this.number.equals(other.number)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    public BallNumber getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number.equals(ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

    @Override
    public String toString() {
        return "Ball{" + "position=" + position + ", number=" + number + '}';
    }
}
