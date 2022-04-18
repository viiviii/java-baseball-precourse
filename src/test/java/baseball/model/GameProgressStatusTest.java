package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class GameProgressStatusTest {

    @Test
    void 인풋_값이_1이면_새로운_게임을_원한다() {
        //given
        String wantNewGame = "1";

        //when
        GameProgressStatus gameProgressNumber = GameProgressStatus.fromString(wantNewGame);

        //then
        assertThat(gameProgressNumber).isEqualTo(GameProgressStatus.NEW_GAME_START);

    }

    @Test
    void 인풋_값이_2이면_게임종료를_원한다() {
        //given
        String wantGameEnd = "2";

        //when
        GameProgressStatus gameProgressNumber = GameProgressStatus.fromString(wantGameEnd);

        //then
        assertThat(gameProgressNumber).isEqualTo(GameProgressStatus.EXIT_APPLICATION);
    }

    @Test
    void 인풋_값이_잘못된_값이면_IllegalArgumentException이_발생한다() {
        //given
        String notOneOrTwo = "3";

        //when
        Throwable thrown = catchThrowable(() -> GameProgressStatus.fromString(notOneOrTwo));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equality() {
        //given
        String wantNewGame = "1";

        //when
        GameProgressStatus gameProgressNumber = GameProgressStatus.fromString(wantNewGame);

        //then
        GameProgressStatus expected = GameProgressStatus.NEW_GAME_START;
        assertThat(gameProgressNumber).isEqualTo(expected);
        assertThat(gameProgressNumber).hasSameHashCodeAs(expected);
    }
}