package baseball.controller;

import static baseball.Score.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import baseball.Computer;
import baseball.Score;
import baseball.view.InputView;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControllerTest {

    private final InputView inputView = mock(InputView.class);
    private final Computer computer = mock(Computer.class);
    private final Controller controller = new Controller(inputView, computer);

    @DisplayName("사용자에게 입력받은 값과 컴퓨터의 값을 비교하기")
    @Test
    void compareTwoBalls() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        given(inputView.ballNumbers()).willReturn(numbers);
        given(computer.ballNumbers()).willReturn(numbers);

        //when
        List<Score> scores = controller.compareTwoBalls();

        //then
        assertThat(scores).containsExactly(STRIKE, STRIKE, STRIKE);
    }
}
