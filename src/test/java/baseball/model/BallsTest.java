package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class BallsTest {

    @DisplayName("문자열로 생성한다")
    @Test
    void createBallsFromString() {
        //given
        String numbers = "123";

        //when
        Throwable thrown = catchThrowable(() -> ballsFromString(numbers));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("숫자 리스트로 생성한다")
    @Test
    void createBallsFromIntegers() {
        //given
        List<Integer> integers = Arrays.asList(1, 2, 3);

        //when
        Throwable thrown = catchThrowable(() -> ballsFromIntegers(integers));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("길이가 유효하지 않으면 예외가 발생한다")
    @Test
    void thrownExceptionWhenInvalidLength() {
        //given
        String numbersOfFourLength = "1234";

        //when
        Throwable thrown = catchThrowable(() -> ballsFromString(numbersOfFourLength));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 값이 있는 경우 예외가 발생한다")
    @Test
    void thrownExceptionWhenDuplicateValues() {
        //given
        String numbersWithDuplicateValues = "112";

        //when
        Throwable thrown = catchThrowable(() -> ballsFromString(numbersWithDuplicateValues));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위가 유효하지 않으면 예외가 발생한다")
    @Test
    void thrownExceptionWhenInvalidRanges() {
        //given
        String numbersWithInvalidValue = "-523";

        //when
        Throwable thrown = catchThrowable(() -> ballsFromString(numbersWithInvalidValue));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 파싱할 수 없으면 예외가 발생한다")
    @Test
    void thrownExceptionWhenInvalidString() {
        //given
        String str = "a1";

        //when
        Throwable thrown = catchThrowable(() -> Balls.fromString(str));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동등성 테스트")
    @Test
    void equality() {
        //given, when
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> otherNumbers = Arrays.asList(1, 2, 3);

        Balls balls = ballsFromIntegers(numbers);
        Balls otherBalls = ballsFromIntegers(otherNumbers);

        //then
        assertThat(balls)
                .isEqualTo(otherBalls)
                .hasSameHashCodeAs(otherBalls);
    }

    @DisplayName("생성 후에 값이 변경되지 않는다")
    @Test
    void immutableWithMutableCollection() {
        //given
        List<Integer> mutable = Arrays.asList(1, 2, 3);

        //when
        Balls balls = ballsFromIntegers(mutable);
        mutable.set(0, 4);

        //then
        Balls expected = ballsFromIntegers(Arrays.asList(1, 2, 3));
        assertThat(balls).isEqualTo(expected);
    }

    @DisplayName("생성 후에 길이가 변경되지 않는다")
    @Test
    void immutableWithGrowableCollection() {
        //given
        List<Integer> growable = new ArrayList<>(Arrays.asList(1, 2, 3));

        //when
        Balls balls = ballsFromIntegers(growable);
        growable.add(4);
        growable.add(5);

        //then
        Balls expected = ballsFromIntegers(Arrays.asList(1, 2, 3));
        assertThat(balls).isEqualTo(expected);
    }

    private Balls ballsFromString(String numbers) {
        return Balls.fromString(numbers);
    }

    private Balls ballsFromIntegers(List<Integer> integers) {
        return Balls.fromIntegers(integers);
    }
}
