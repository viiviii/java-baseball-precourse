package baseball;

import baseball.score.Score;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static baseball.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MessageTest {

    private Message message = new Message();

    @Test
    void 볼과_스트라이크가_함께_있는_경우_볼_힌트가_먼저_온다() {
        //given
        final int ONE_COUNT = 1;
        Score score = mock(Score.class);
        given(score.get(BALL)).willReturn(ONE_COUNT);
        given(score.get(STRIKE)).willReturn(ONE_COUNT);

        //when
        String msg = message.toHint(score);

        //then
        String expected = String.format("%d%s %d%s", ONE_COUNT, "볼", ONE_COUNT, "스트라이크");
        assertThat(msg).isEqualTo(expected);
    }

    @Test
    void 힌트_이름은_스크라이크_볼_낫싱이다() {
        // when
        String strike = message.hintName(STRIKE);
        String ball = message.hintName(BALL);
        String nothing = message.hintName(NOTHING);

        //then
        assertThat(strike).isEqualTo("스트라이크");
        assertThat(ball).isEqualTo("볼");
        assertThat(nothing).isEqualTo("낫싱");
    }

    @ParameterizedTest
    @EnumSource(Hint.class)
    void 힌트는_모두_이름이_있다(Hint hint) {
        //when
        String msg = message.hintName(hint);

        //then
        assertThat(msg).isNotBlank();
    }

    @Test
    void 올_스트라이크_메세지() {
        //when
        String msg = message.allStrike();

        //then
        assertThat(msg).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); // TODO: 하드코딩 제거(3)
    }

    @Test
    void 게임_재시작_선택_메세지() {
        //when
        String msg = message.continueNewGame();

        //then
        assertThat(msg).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); // TODO: 하드코딩 제거(1, 2)
    }
}