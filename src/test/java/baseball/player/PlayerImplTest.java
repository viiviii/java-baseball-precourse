package baseball.player;

import baseball.view.View;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PlayerImplTest {

    private View view = mock(View.class);
    private Player player = new PlayerImpl(view);

    @Test
    void 인풋_값이_1이면_새로운_게임을_원한다() {
        //given
        String wantNewGame = "1";
        given(view.inputContinueNewGame()).willReturn(wantNewGame);

        //when
        boolean continueNewGame = player.wantContinueNewGame();

        //then
        assertThat(continueNewGame).isTrue();
    }

    @Test
    void 인풋_값이_2이면_게임종료를_원한다() {
        //given
        String wantGameEnd = "2";
        given(view.inputContinueNewGame()).willReturn(wantGameEnd);

        //when
        boolean continueNewGame = player.wantContinueNewGame();

        //then
        assertThat(continueNewGame).isFalse();
    }

    @Test
    void 인풋_값이_잘못된_값이면_IllegalArgumentException이_발생한다() {
        //given
        String notOneOrTwo = "3";
        given(view.inputContinueNewGame()).willReturn(notOneOrTwo);

        //when
        Throwable thrown = catchThrowable(() -> player.wantContinueNewGame());

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}