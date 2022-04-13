package baseball;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: 예외에 의미있는 메세지를 담아서 던지기
public class GameNumbers {
    private final List<Integer> numbers;

    public GameNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRangeOfEachNumber(numbers);
        this.numbers = numbers;
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
}
