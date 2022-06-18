package baseball;

import static baseball.Score.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import baseball.util.MyRandoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControllerTest {

    private final InputView inputView = new StubInputView();
    private final MyRandoms myRandoms = mock(MyRandoms.class);

    @DisplayName("사용자에게 입력받은 값과 컴퓨터의 값을 비교하기")
    @Test
    void input() {
        //given
        List<Integer> playerBallNumbers = inputView.ballNumbers();
        Balls playerBalls = Balls.of(playerBallNumbers);

        given(myRandoms.pickNumberInRange(anyInt(), anyInt())).willReturn(1, 2, 3);
        Computer computer = new Computer(myRandoms);
        List<Integer> computerBallNumbers = computer.randomBallNumbers();
        Balls computerBalls = Balls.of(computerBallNumbers);

        //when
        Scorer scorer = new Scorer();
        List<Score> scores = scorer.totalScoreTo(playerBalls, computerBalls);

        //then
        assertThat(scores).containsExactly(STRIKE, STRIKE, STRIKE);
    }

    public interface InputView {
        List<Integer> ballNumbers();
    }

    public static final class StubInputView implements InputView {

        @Override
        public List<Integer> ballNumbers() {
            return Arrays.asList(1, 2, 3);
        }
    }
}
