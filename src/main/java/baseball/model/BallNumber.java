package baseball.model;

import baseball.game.Game;

import java.util.Objects;

final class BallNumber {
    private final int number;

    public BallNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        final int start = Game.START_NUMBER;
        final int end = Game.END_NUMBER;
        if (number < start || number > end) {
            final String message = String.format("게임숫자는 %d ~ %d까지 숫자만 가능합니다.", start, end);
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumber)) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "BallNumber{" + "number=" + number + '}';
    }
}
