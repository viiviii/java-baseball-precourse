package baseball.view;

import baseball.score.Score;
import baseball.view.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static baseball.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ConsoleViewTest {

    private Message message = mock(Message.class);
    private Score score = mock(Score.class);
    private ConsoleView view = new ConsoleView(message);

    private int count = 1;
    private String strikeName = "스트라이크";
    private String ballName = "볼";
    private String nothingName = "낫싱";

    @BeforeEach
    void setUp() {
        given(message.hintName(STRIKE)).willReturn(strikeName);
        given(message.hintName(BALL)).willReturn(ballName);
        given(message.hintName(NOTHING)).willReturn(nothingName);
    }

    @Test
    void 낫싱만_있는_경우_힌트이름인_문자열만_리턴한다() {
        //given
        given(score.isAllNothing()).willReturn(true);
        given(score.getCount(NOTHING)).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(nothingName);
    }

    @Test
    void 스트라이크만_있는_경우_점수와_힌트이름을_합친_문자열을_리턴한다() {
        //given
        given(score.getCount(STRIKE)).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(count + strikeName);
    }

    @Test
    void 볼만_있는_경우_점수와_힌트이름을_합친_문자열을_리턴한다() {
        //given
        given(score.getCount(BALL)).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(count + ballName);
    }

    @Test
    void 볼과_스트라이크가_함께_있는_경우_볼_힌트가_먼저_온다() {
        //given
        given(score.getCount(STRIKE)).willReturn(count);
        given(score.getCount(BALL)).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(count + ballName + " " + count + strikeName);
    }

    @Test
    void 낫싱이_다른_힌트와_함께_있는_경우_낫싱은_출력되지_않는다() {
        //given
        given(score.getCount(STRIKE)).willReturn(count);
        given(score.getCount(NOTHING)).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(count + strikeName);
    }
}
