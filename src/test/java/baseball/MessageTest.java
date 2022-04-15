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

    private Score score = mock(Score.class);
    private Message message = new Message(score);

    @Test
    void 볼과_스트라이크가_함께_있는_경우_볼_힌트가_먼저_온다() {
        //given
        final int count = 1;
        given(score.get(BALL)).willReturn(count);
        given(score.get(STRIKE)).willReturn(count);

        //when
        String hint = message.toHint();

        //then
        String expected = String.format("%d%s %d%s", count, "볼", count, "스트라이크");
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
    void 모든_hint는_이름이_있다(Hint hint) {
        //when
        String hintName = message.hintName(hint);

        //then
        assertThat(hintName).isNotBlank();
    }
}