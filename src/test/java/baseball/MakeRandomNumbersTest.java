package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MakeRandomNumbersTest {

    private MyRandoms randoms = mock(MyRandoms.class);

    @DisplayName("중복된 값이 있는 경우")
    @Test
    void pickRandomBallNumbersTest() {
        //given
        given(randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(1, 2, 1, 3, 4);

        //when
        List<Integer> randomBallNumbers = pickRandomBallNumbers();

        //then
        assertThat(randomBallNumbers).containsExactlyInAnyOrder(1, 2, 3);
    }

    private List<Integer> pickRandomBallNumbers() {
        final Set<Integer> uniqueBallNumbers = new HashSet<>();
        while (uniqueBallNumbers.size() < 3) {
            final int numbers = randoms.pickNumberInRange(1, 9);
            uniqueBallNumbers.add(numbers);
        }
        return new ArrayList<>(uniqueBallNumbers);
    }

    public static final class MyRandoms {

        public int pickNumberInRange(int startInclusive, int endInclusive) {
            return Randoms.pickNumberInRange(startInclusive, endInclusive);
        }
    }
}
