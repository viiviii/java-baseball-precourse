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
        String hint = message.toHint(score);

        //then
        String expected = String.format("%d%s %d%s", ONE_COUNT, "볼", ONE_COUNT, "스트라이크");
        assertThat(hint).isEqualTo(expected);
    }

    @Test
    void hintNames() {
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
        String hintName = message.hintName(hint);

        //then
        assertThat(hintName).isNotBlank();
    }
}