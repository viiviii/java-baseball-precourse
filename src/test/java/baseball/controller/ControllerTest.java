package baseball.controller;

import static baseball.domain.Score.STRIKE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import baseball.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class ControllerTest {

    private final InputView inputView = mock(InputView.class);
    private final OutputView outputView = mock(OutputView.class);
    private final Computer computer = mock(Computer.class);
    private final Controller controller = new Controller(inputView, outputView, computer);

    @DisplayName("플레이어에게 값을 입력받아 컴퓨터의 값과 비교한 결과를 사용자에게 출력한다")
    @Test
    void play() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        given(inputView.ballNumbers()).willReturn(numbers);
        given(computer.ballNumbers()).willReturn(numbers);
        InOrder inOrder = inOrder(outputView, computer, inputView);

        //when
        controller.play();

        //then
        inOrder.verify(computer).ballNumbers();
        inOrder.verify(outputView).selectNumberRequest();
        inOrder.verify(inputView).ballNumbers();
        inOrder.verify(outputView).selectNumberResponse(Arrays.asList(STRIKE, STRIKE, STRIKE));
        inOrder.verify(outputView).perfectScore();
    }

    @DisplayName("플레이어가 정답을 맞출 때까지 플레이를 반복한다")
    @Test
    void repeatPlay() {
        //given
        int selectCount = 2;
        List<Integer> correct = Arrays.asList(1, 2, 3);
        List<Integer> nothing = Arrays.asList(7, 8, 9);

        given(inputView.ballNumbers()).willReturn(nothing, correct);
        given(computer.ballNumbers()).willReturn(correct);

        //when
        controller.play();

        //then
        verify(computer, only()).ballNumbers();
        verify(outputView, times(selectCount)).selectNumberRequest();
        verify(inputView, times(selectCount)).ballNumbers();
        verify(outputView, times(selectCount)).selectNumberResponse(any());
        verify(outputView).perfectScore();
    }
}
