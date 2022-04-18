package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class GameNumbersTest {

    @DisplayName("문자열로 게임 숫자를 생성한다")
    @Test
    void createGameNumberFromString() {
        //given
        String numbers = "123";

        //when
        Throwable thrown = catchThrowable(() -> gameNumbersFromString(numbers));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("숫자 리스트로 게임 숫자를 생성한다")
    @Test
    void createGameNumberFromIntegers() {
        //given
        List<Integer> integers = Arrays.asList(1, 2, 3);

        //when
        Throwable thrown = catchThrowable(() -> gameNumbersFromIntegers(integers));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("게임숫자 길이가 유효하지 않으면 예외가  발생한다")
    @Test
    void thrownExceptionWhenInvalidLength() {
        //given
        String numbersOfFourLength = "1234";

        //when
        Throwable thrown = catchThrowable(() -> gameNumbersFromString(numbersOfFourLength));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임숫자에 중복 값이 있는 경우 예외가 발생한다")
    @Test
    void thrownExceptionWhenDuplicateValues() {
        //given
        String numbersWithDuplicateValues = "112";

        //when
        Throwable thrown = catchThrowable(() -> gameNumbersFromString(numbersWithDuplicateValues));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임숫자 범위가 유효하지 않으면 예외가 발생한다")
    @Test
    void thrownExceptionWhenInvalidRanges() {
        //given
        String numberWithInvalidValue = "-523";

        //when
        Throwable thrown = catchThrowable(() -> gameNumbersFromString(numberWithInvalidValue));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 게임숫자로 파싱할 수 없으면 예외가 발생한다")
    @Test
    void thrownExceptionWhenInvalidString() {
        //given
        String str = "a1";

        //when
        Throwable thrown = catchThrowable(() -> GameNumbers.fromString(str));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동등성 테스트")
    @Test
    void equality() {
        //given, when
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> otherNumbers = Arrays.asList(1, 2, 3);

        GameNumbers gameNumbers = gameNumbersFromIntegers(numbers);
        GameNumbers otherGameNumbers = gameNumbersFromIntegers(otherNumbers);

        //then
        assertThat(gameNumbers).isEqualTo(otherGameNumbers);
        assertThat(gameNumbers).hasSameHashCodeAs(otherGameNumbers);
    }

    @DisplayName("게임숫자는 생성 후에 값이 변경되지 않는다")
    @Test
    void immutableWithMutableCollection() {
        //given
        List<Integer> mutable = Arrays.asList(1, 2, 3);

        //when
        GameNumbers gameNumbers = gameNumbersFromIntegers(mutable);
        mutable.set(0, 4);

        //then
        GameNumbers expected = gameNumbersFromIntegers(Arrays.asList(1, 2, 3));
        assertThat(gameNumbers).isEqualTo(expected);
    }

    @DisplayName("게임숫자는 생성 후에 길이가 변경되지 않는다")
    @Test
    void immutableWithGrowableCollection() {
        //given
        List<Integer> growable = new ArrayList<>(Arrays.asList(1, 2, 3));

        //when
        GameNumbers gameNumbers = gameNumbersFromIntegers(growable);
        growable.add(4);
        growable.add(5);

        //then
        GameNumbers expected = gameNumbersFromIntegers(Arrays.asList(1, 2, 3));
        assertThat(gameNumbers).isEqualTo(expected);
    }

    private GameNumbers gameNumbersFromString(String numbers) {
        return GameNumbers.fromString(numbers);
    }

    private GameNumbers gameNumbersFromIntegers(List<Integer> integers) {
        return GameNumbers.fromIntegers(integers);
    }
}
