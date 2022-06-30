package baseball.gameStrategy;

import java.util.Objects;

final class BallNumber {
    private final int value;

    public BallNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int ballNumber) {
        if (ballNumber < 1 || ballNumber > 9) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallNumber)) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
