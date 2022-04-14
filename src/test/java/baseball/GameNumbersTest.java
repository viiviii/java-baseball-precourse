package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

// TODO: 테스트 메서드명 영어로 바꾸고 @DisplayName으로 변경
// TODO: 테스트에서 유효하지 않은 값, 유효한 값 하드코딩 된 부분 개선 가능한가? -> 경계값 + 중간값은 Randoms에 메서드 사용해서 3개 뽑기?
public class GameNumbersTest {

    @Test
    void 올바른_게임숫자() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        //when
        Throwable thrown = catchThrowable(() -> new GameNumbers(numbers));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @Test
    void 게임_숫자는_3개가_아니면_예외가_발생한다() {
        //given
        List<Integer> numbersOfFourLength = Arrays.asList(1, 2, 3, 4);

        //when
        Throwable thrown = catchThrowable(() -> new GameNumbers(numbersOfFourLength));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_숫자가_중복된_경우_예외가_발생한다() {
        //given
        Integer duplicate = 1;
        List<Integer> numbersWithDuplicateValues = Arrays.asList(duplicate, duplicate, 3);

        //when
        Throwable thrown = catchThrowable(() -> new GameNumbers(numbersWithDuplicateValues));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_숫자_범위가_유효하지_않으면_예외가_발생한다() {
        //given
        Integer invalid = -1;
        List<Integer> numberWithInvalidValue = Arrays.asList(invalid, 2, 3);

        //when
        Throwable thrown = catchThrowable(() -> new GameNumbers(numberWithInvalidValue));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equality() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> otherNumbers = Arrays.asList(1, 2, 3);
        GameNumbers gameNumbers = new GameNumbers(numbers);
        GameNumbers otherGameNumbers = new GameNumbers(otherNumbers);

        //when
        boolean equals = gameNumbers.equals(otherGameNumbers);

        //then
        assertThat(equals).isTrue();
    }

    @Test
    void hashCodeEquality() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> otherNumbers = Arrays.asList(1, 2, 3);
        GameNumbers gameNumbers = new GameNumbers(numbers);
        GameNumbers otherGameNumbers = new GameNumbers(otherNumbers);

        //when
        boolean equals = gameNumbers.hashCode() == otherGameNumbers.hashCode();

        //then
        assertThat(equals).isTrue();
    }
}
