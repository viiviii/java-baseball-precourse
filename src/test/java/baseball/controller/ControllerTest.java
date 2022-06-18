package baseball.controller;

import static baseball.Score.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import baseball.Score;
import baseball.util.MyRandoms;
import baseball.view.InputView;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControllerTest {

    private final InputView inputView = new StubInputView();
    private final MyRandoms myRandoms = mock(MyRandoms.class);
    private final Controller controller = new Controller(inputView, myRandoms);

    @DisplayName("사용자에게 입력받은 값과 컴퓨터의 값을 비교하기")
    @Test
    void input() {
        //given
        given(myRandoms.pickNumberInRange(anyInt(), anyInt())).willReturn(1, 2, 3);

        //when
        List<Score> scores = controller.compareTwoBalls();

        //then
        assertThat(scores).containsExactly(STRIKE, STRIKE, STRIKE);
    }


    public static final class StubInputView implements InputView {
        @Override
        public List<Integer> ballNumbers() {
            return Arrays.asList(1, 2, 3);
        }
    }
}
