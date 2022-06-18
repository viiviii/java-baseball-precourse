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
import org.mockito.verification.VerificationMode;

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
        controller.start();

        //then
        inOrder.verify(computer).ballNumbers();
        inOrder.verify(outputView).selectNumberRequest();
        inOrder.verify(inputView).ballNumbers();
        inOrder.verify(outputView).selectNumberResponse(Arrays.asList(STRIKE, STRIKE, STRIKE));
        inOrder.verify(outputView).perfectScore();
        inOrder.verify(outputView).startNewGame();
        inOrder.verify(inputView).startNewGame();
    }

    @DisplayName("정답을 맞출 때까지 플레이어에게 숫자를 요청한다")
    @Test
    void requestPlayerForNumberUntilCorrect() {
        //given
        List<Integer> correct = Arrays.asList(1, 2, 3);
        List<Integer> nothing = Arrays.asList(7, 8, 9);

        given(inputView.ballNumbers()).willReturn(nothing, correct);
        given(computer.ballNumbers()).willReturn(correct);

        //when
        controller.start();

        //then
        VerificationMode tryingTwice = times(2);
        verify(computer, only()).ballNumbers();
        verify(outputView, tryingTwice).selectNumberRequest();
        verify(inputView, tryingTwice).ballNumbers();
        verify(outputView, tryingTwice).selectNumberResponse(any());
        verify(outputView).perfectScore();
        verify(outputView).startNewGame();
        verify(inputView).startNewGame();
    }

    @DisplayName("게임이 종료된 후 새로운 게임을 다시 시작한다")
    @Test
    void startNewGame() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        given(inputView.ballNumbers()).willReturn(numbers);
        given(computer.ballNumbers()).willReturn(numbers);
        given(inputView.startNewGame()).willReturn(true, false);

        //when
        controller.start();

        //then
        VerificationMode playingTwice = times(2);
        verify(computer, playingTwice).ballNumbers();
        verify(outputView, playingTwice).perfectScore();
        verify(outputView, playingTwice).startNewGame();
        verify(inputView, playingTwice).startNewGame();
    }
}
