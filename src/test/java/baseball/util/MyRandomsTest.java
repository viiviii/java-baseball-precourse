package baseball.util;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mockStatic;

class MyRandomsTest {
    private int startInclusive = Game.START_NUMBER;
    private int endInclusive = Game.END_NUMBER;
    private int count = Game.DIGITS;

    @DisplayName("유니크한 랜덤 숫자 리스트를 생성한다")
    @Test
    void pickUniqueNumbersInRange() {
        try (final MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            //given
            mocked.when(() -> Randoms.pickNumberInRange(startInclusive, endInclusive))
                    .thenReturn(1, 3, 1, 1, 5, 2);

            //when
            List<Integer> actual = MyRandoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

            //then
            List<Integer> expected = Arrays.asList(1, 3, 5);
            assertThat(actual).isEqualTo(expected);
        }
    }

    @DisplayName("카운트가 0보다 작으면 예외가 발생한다")
    @Test
    void thrownExceptionWhenNegativeCount() {
        //given
        int negativeCount = -1;

        //when
        Throwable thrown = catchThrowable(
                () -> MyRandoms.pickUniqueNumbersInRange(startInclusive, endInclusive, negativeCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성할 범위의 숫자 갯수가 카운트보다 작으면 예외가 발생한다")
    @Test
    void thrownExceptionWhenNumberInRangeLessThanCount() {
        //given
        int greaterThanRangeCount = 999;

        //when
        Throwable thrown = catchThrowable(
                () -> MyRandoms.pickUniqueNumbersInRange(startInclusive, endInclusive, greaterThanRangeCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
