package baseball;

import java.util.Objects;

public final class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        validateRange(number);
        this.position = position;
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
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
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    public int number() {
        return number;
    }
}
