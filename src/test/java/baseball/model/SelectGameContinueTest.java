package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class SelectGameContinueTest {

    @DisplayName("1은 새로운 게임 시작을 나타낸다")
    @Test
    void newStartGameCode() {
        //given
        String wantNewGame = "1";

        //when
        SelectGameContinue select = SelectGameContinue.fromString(wantNewGame);

        //then
        assertThat(select).isEqualTo(SelectGameContinue.NEW_GAME_START);

    }

    @DisplayName("2는 게임 종료를 나타낸다")
    @Test
    void exitGameCode() {
        //given
        String wantGameEnd = "2";

        //when
        SelectGameContinue select = SelectGameContinue.fromString(wantGameEnd);

        //then
        assertThat(select).isEqualTo(SelectGameContinue.EXIT_GAME);
    }

    @DisplayName("1과 2가 아닌 경우 예외가 발생한다")
    @Test
    void thrownExceptionWhenInvalidCode() {
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