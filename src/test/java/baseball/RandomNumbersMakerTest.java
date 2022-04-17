package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

public class RandomNumbersMakerTest {

    @Test
    void pickUniqueNumbersInRange() {
        //given
        int start = 1; // TODO
        int end = 9;
        int count = 3;

        try (final MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(start, end)).thenReturn(1, 3, 1, 1, 5, 2);

            //when
            List<Integer> actual = pickUniqueNumbersInRange(start, end, count);

            //then
            List<Integer> expected = Arrays.asList(1, 3, 5);
            assertThat(actual).isEqualTo(expected);
        }
    }
}
