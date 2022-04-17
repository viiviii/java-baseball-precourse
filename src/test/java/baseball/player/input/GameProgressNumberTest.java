package baseball.player.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class GameProgressNumberTest {

    @Test
    void 인풋_값이_1이면_새로운_게임을_원한다() {
        //given
        String wantNewGame = "1";

        //when
        GameProgressNumber gameProgressNumber = GameProgressNumber.fromString(wantNewGame);
        boolean isContinueNewGame = gameProgressNumber.isContinueNewGame();

        //then
        assertThat(isContinueNewGame).isTrue();
    }

    @Test
    void 인풋_값이_2이면_게임종료를_원한다() {
        //given
        String wantGameEnd = "2";

        //when
        GameProgressNumber gameProgressNumber = GameProgressNumber.fromString(wantNewGame);
        boolean isContinueNewGame = gameProgressNumber.isContinueNewGame();

        //then
        assertThat(isContinueNewGame).isFalse();
    }

    @Test
    void 인풋_값이_잘못된_값이면_IllegalArgumentException이_발생한다() {
        //given
        String notOneOrTwo = "3";

        //when
        Throwable thrown = catchThrowable(() -> GameProgressNumber.fromString(wantNewGame));
        boolean isContinueNewGame = gameProgressNumber.isContinueNewGame();

        //then
        assertThat(notOneOrTwo).isInstanceOf(IllegalArgumentException.class);
    }
}