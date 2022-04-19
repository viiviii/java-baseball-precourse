package baseball.model;

import baseball.game.Game;
import baseball.util.Parser;

import java.util.*;

public final class GameNumbers {
    private final List<Integer> numbers;

    private GameNumbers(List<Integer> numbers) {
        final List<Integer> copyNumbers = defensiveCopy(numbers);
        validateSize(copyNumbers);
        validateDuplication(copyNumbers);
        validateRangeOfEachNumber(copyNumbers);
        this.numbers = copyNumbers;
    }

    public static GameNumbers fromIntegers(List<Integer> numbers) {
        return new GameNumbers(numbers);
    }

    public static GameNumbers fromString(String str) {
        try {
            final List<Integer> numbers = Parser.asIntegerList(str);
            return GameNumbers.fromIntegers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임숫자는 숫자만 가능합니다");
        }
    }

    private List<Integer> defensiveCopy(List<Integer> numbers) {
        return new ArrayList<>(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Game.DIGITS) {
            final String message = String.format("게임숫자는 %d 자리의 수여야 합니다", Game.DIGITS);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        final Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != deduplicatedNumbers.size()) {
            throw new IllegalArgumentException("게임숫자는 서로 다른 수로 이루어져야 합니다");
        }
    }

    private void validateRangeOfEachNumber(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
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
        return numbers.size();
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameNumbers)) return false;
        GameNumbers that = (GameNumbers) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "GameNumbers{" + "numbers=" + numbers + '}';
    }
}
