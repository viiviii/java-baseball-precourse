package baseball.view;

import baseball.model.Score;
import baseball.view.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.model.Hint.*;
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

    @DisplayName("낫싱만 있는 경우 힌트이름인 문자열만 리턴한다")
    @Test
    void onlyHintNameWhenNothing() {
        //given
        given(score.isNothing()).willReturn(true);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(nothingName);
    }

    @DisplayName("스트라이크일 땐 점수와 힌트이름을 합친 문자열을 리턴한다")
    @Test
    void countAndHintNameWhenStrike() {
        //given
        given(score.getStrike()).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(count + strikeName);
    }

    @DisplayName("볼일 땐 점수와 힌트이름을 합친 문자열을 리턴한다")
    @Test
    void countAndHintNameWhenBall() {
        //given
        given(score.getBall()).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(count + ballName);
    }

    @DisplayName("볼과_스트라이크가_함께_있는_경우_볼_힌트가_먼저_온다")
    @Test
    void ballMessageFirstWhenBallAndStrikeTogether() {
        //given
        given(score.getStrike()).willReturn(count);
        given(score.getBall()).willReturn(count);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(count + ballName + " " + count + strikeName);
    }
}
