package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class SelectGameContinueTest {

    @Test
    void 인풋_값이_1이면_새로운_게임을_원한다() {
        //given
        String wantNewGame = "1";

        //when
        SelectGameContinue select = SelectGameContinue.fromString(wantNewGame);

        //then
        assertThat(select).isEqualTo(SelectGameContinue.NEW_GAME_START);

    }

    @Test
    void 인풋_값이_2이면_게임종료를_원한다() {
        //given
        String wantGameEnd = "2";

        //when
        SelectGameContinue select = SelectGameContinue.fromString(wantGameEnd);

        //then
        assertThat(select).isEqualTo(SelectGameContinue.EXIT_GAME);
    }

    @Test
    void 인풋_값이_잘못된_값이면_IllegalArgumentException이_발생한다() {
        //given
        String invalid = "3";

        //when
        Throwable thrown = catchThrowable(() -> SelectGameContinue.fromString(invalid));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equality() {
        //given
        String wantNewGame = "1";

        //when
        SelectGameContinue select = SelectGameContinue.fromString(wantNewGame);

        //then
        SelectGameContinue expected = SelectGameContinue.NEW_GAME_START;
        assertThat(select).isEqualTo(expected);
        assertThat(select).hasSameHashCodeAs(expected);
    }
}