package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mockStatic;

public class MyRandomsTest {

    private int startInclusive = 1;
    private int endInclusive = 9;
    private int count = 3;

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

    @Test
    void 카운트가_0보다_작으면_IllegalArgumentException이_발생한다() {
        //given
        int negativeCount = -1;

        //when
        Throwable thrown = catchThrowable(
                () -> MyRandoms.pickUniqueNumbersInRange(startInclusive, endInclusive, negativeCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성할_범위의_숫자_갯수가_카운트보다_작으면_IllegalArgumentException이_발생한다() {
        //given
        int greaterThanRangeCount = 999;

        //when
        Throwable thrown = catchThrowable(
                () -> MyRandoms.pickUniqueNumbersInRange(startInclusive, endInclusive, greaterThanRangeCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
