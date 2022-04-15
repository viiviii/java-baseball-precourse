package baseball;

import baseball.score.Score;
import org.junit.jupiter.api.Test;

import static baseball.Hint.BALL;
import static baseball.Hint.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MessageTest {

    private Score score = mock(Score.class);

    @Test
    void 볼과_스트라이크가_함께_있는_경우_볼_힌트가_먼저_온다() {
        //given
        final int count = 1;
        given(score.get(BALL)).willReturn(count);
        given(score.get(STRIKE)).willReturn(count);
        Message message = new Message(score);

        //when
        String hint = message.toHint();

        //then
        String expected = String.format("%d%s %d%s", count, BALL.getName(), count, STRIKE.getName());
        assertThat(hint).isEqualTo(expected);
    }
}