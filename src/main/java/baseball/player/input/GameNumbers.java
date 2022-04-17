package baseball.player.input;

import java.util.*;

// TODO: 예외에 의미있는 메세지를 담아서 던지기
public final class GameNumbers {

    private final List<Integer> numbers;

    public GameNumbers(List<Integer> numbers) {
        final List<Integer> copyNumbers = defensiveCopy(numbers);
        validateSize(copyNumbers);
        validateDuplication(copyNumbers);
        validateRangeOfEachNumber(copyNumbers);
        this.numbers = copyNumbers;
    }

    private List<Integer> defensiveCopy(List<Integer> numbers) {
        return new ArrayList<>(numbers);
    }

    private void validateSize(Collection<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        final Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != deduplicatedNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRangeOfEachNumber(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
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