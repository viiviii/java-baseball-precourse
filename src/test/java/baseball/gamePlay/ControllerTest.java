package baseball.gamePlay;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.verification.VerificationMode;

class ControllerTest {

    private final Player player = mock(Player.class);
    private final Computer computer = mock(Computer.class);
    private final Controller controller = new Controller(player, computer);

    @DisplayName("플레이어에게 값을 입력받아 컴퓨터의 값과 비교한 결과를 사용자에게 출력한다")
    @Test
    void play() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        given(computer.ballNumbers()).willReturn(numbers);
        given(player.guessBalls()).willReturn(numbers);
        InOrder inOrder = inOrder(computer, player);

        //when
        controller.start();

        //then
        inOrder.verify(computer).ballNumbers();
        inOrder.verify(player).guessBalls();
        inOrder.verify(player).announceScore(any());
        inOrder.verify(player).guessStartNewGame();
    }

    @DisplayName("정답을 맞출 때까지 플레이어에게 숫자를 요청한다")
    @Test
    void requestPlayerForNumberUntilCorrect() {
        //given
        List<Integer> correct = Arrays.asList(1, 2, 3);
        List<Integer> nothing = Arrays.asList(7, 8, 9);

        given(computer.ballNumbers()).willReturn(correct);
        given(player.guessBalls()).willReturn(nothing, correct);

        //when
        controller.start();

        //then
        VerificationMode tryingTwice = times(2);
        verify(computer, only()).ballNumbers();
        verify(player, tryingTwice).guessBalls();
        verify(player, tryingTwice).announceScore(any());
        verify(player).guessStartNewGame();
    }

    @DisplayName("게임이 종료된 후 새로운 게임을 다시 시작한다")
    @Test
    void startNewGame() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        given(computer.ballNumbers()).willReturn(numbers);
        given(player.guessBalls()).willReturn(numbers);
        given(player.guessStartNewGame()).willReturn(true, false);

        //when
        controller.start();

        //then
        VerificationMode playingTwice = times(2);
        verify(computer, playingTwice).ballNumbers();
        verify(player, playingTwice).guessStartNewGame();
    }
}
