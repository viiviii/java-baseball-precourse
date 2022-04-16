package baseball.player;

import baseball.GameNumbers;
import baseball.parser.Parser;
import baseball.view.View;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PlayerImplTest {

    private View controller = mock(View.class);
    private Player player = new PlayerImpl(controller);

    // TODO: 테스트가 이상해
    @Test
    void guess() {
        //given
        String input = "123";
        given(controller.input()).willReturn(input);

        //when
        GameNumbers guess = player.guess();

        //then
        GameNumbers expected = Parser.asGameNumbers(input);
        assertThat(guess).isEqualTo(expected);
    }

    @Test
    void 인풋_값이_1이면_새로운_게임을_원한다() {
        //given
        String wantNewGame = "1";
        given(controller.input()).willReturn(wantNewGame);

        //when
        boolean continueNewGame = player.wantContinueNewGame();

        //then
        assertThat(continueNewGame).isTrue();
    }

    @Test
    void 인풋_값이_2이면_게임종료를_원한다() {
        //given
        String wantGameEnd = "2";
        given(controller.input()).willReturn(wantGameEnd);

        //when
        boolean continueNewGame = player.wantContinueNewGame();

        //then
        assertThat(continueNewGame).isFalse();
    }

    @Test
    void 인풋_값이_잘못된_값이면_IllegalArgumentException이_발생한다() {
        //given
        String notOneOrTwo = "3";
        given(controller.input()).willReturn(notOneOrTwo);

        //when
        Throwable thrown = catchThrowable(() -> player.wantContinueNewGame());

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}