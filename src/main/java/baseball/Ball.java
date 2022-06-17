package baseball;

import java.util.Objects;

public final class Ball {
    private final int position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BallNumber(number);
    }

    public boolean hasSameNumber(Ball other) {
        return this.number.equals(other.number);
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
