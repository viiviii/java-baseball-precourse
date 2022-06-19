package baseball.gamePlay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import baseball.util.MyRandoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private MyRandoms randoms = mock(MyRandoms.class);
    private Computer computer = new Computer(randoms);

    @DisplayName("랜덤한 야구 숫자를 생성한다")
    @Test
    void createRandomBallNumbers() {
        //given
        given(randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(1, 2, 1, 3, 4);

        //when
        List<Integer> randomBallNumbers = computer.ballNumbers();

        //then
        assertThat(randomBallNumbers).containsExactlyInAnyOrder(1, 2, 3);
    }
}
