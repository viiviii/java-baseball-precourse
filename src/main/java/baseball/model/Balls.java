package baseball.model;

import baseball.game.Game;
import baseball.util.Parser;

import java.util.*;

public final class Balls {
    private final List<Integer> balls;

    private Balls(List<Integer> balls) {
        final List<Integer> copy = defensiveCopy(balls);
        validateSize(copy);
        validateDuplication(copy);
        validateRangeOfEachNumber(copy);
        this.balls = copy;
    }

    public static Balls fromIntegers(List<Integer> balls) {
        return new Balls(balls);
    }

    public static Balls fromString(String str) {
        try {
            final List<Integer> numbers = Parser.asIntegerList(str);
            return Balls.fromIntegers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임숫자는 숫자만 가능합니다");
        }
    }

    private List<Integer> defensiveCopy(List<Integer> balls) {
        return new ArrayList<>(balls);
    }

    private void validateSize(List<Integer> balls) {
        if (balls.size() != Game.DIGITS) {
            final String message = String.format("게임숫자는 %d 자리의 수여야 합니다", Game.DIGITS);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateDuplication(List<Integer> balls) {
        final Set<Integer> noDuplicates = new HashSet<>(balls);
        if (balls.size() != noDuplicates.size()) {
            throw new IllegalArgumentException("게임숫자는 서로 다른 수로 이루어져야 합니다");
        }
    }

    private void validateRangeOfEachNumber(List<Integer> balls) {
        balls.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        final int start = Game.START_NUMBER;
        final int end = Game.END_NUMBER;
        if (number < start || number > end) {
            final String message = String.format("게임숫자는 %d ~ %d까지 숫자만 가능합니다.", start, end);
            throw new IllegalArgumentException(message);
        }
    }

    public int size() {
        return balls.size();
    }

    public boolean contains(Integer number) {
        return balls.contains(number);
    }

    public Integer get(int index) {
        return balls.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balls)) return false;
        Balls that = (Balls) o;
        return balls.equals(that.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        return "Balls{" + "balls=" + balls + '}';
    }
}
