package baseball.view;

import baseball.Hint;
import baseball.score.Match;
import baseball.score.Score;
import baseball.view.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ConsoleViewTest {

    private Message message = mock(Message.class);
    private Score score = mock(Score.class);
    private ConsoleView view = new ConsoleView(message);

    private int points = 2;
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
        given(score.isNothing()).willReturn(true);
        given(score.get(NOTHING)).willReturn(points);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(nothingName);
    }

    @Test
    void 스트라이크만_있는_경우_점수와_힌트이름을_합친_문자열을_리턴한다() {
        //given
        Match match = createMatch(STRIKE, points);
        given(score.matches()).willReturn(asList(match));
        given(score.get(STRIKE)).willReturn(points);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(points + strikeName);
    }

    @Test
    void 볼만_있는_경우_점수와_힌트이름을_합친_문자열을_리턴한다() {
        //given
        Match match = createMatch(BALL, points);
        given(score.matches()).willReturn(asList(match));
        given(score.get(BALL)).willReturn(points);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(points + ballName);
    }

    @Test
    void 볼과_스트라이크가_함께_있는_경우_볼_힌트가_먼저_온다() {
        //given
        Match strikeMatch = createMatch(STRIKE, points);
        Match ballMatch = createMatch(BALL, points);
        given(score.matches()).willReturn(asList(strikeMatch, ballMatch));
        given(score.get(STRIKE)).willReturn(points);
        given(score.get(BALL)).willReturn(points);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(points + ballName + " " + points + strikeName);
    }

    @Test
    void 낫싱이_다른_힌트와_함께_있는_경우_낫싱은_출력되지_않는다() {
        //given
        Match strikeMatch = createMatch(STRIKE, points);
        Match strikeNothing = createMatch(NOTHING, points);
        given(score.matches()).willReturn(asList(strikeNothing, strikeMatch));
        given(score.get(STRIKE)).willReturn(points);
        given(score.get(NOTHING)).willReturn(points);

        //when
        String message = view.scoreMessage(score);

        //then
        assertThat(message).isEqualTo(points + strikeName);
    }

    private Match createMatch(Hint hint, int points) {
        return new Match(hint, points);
    }

    private List<Match> asList(Match... matches) {
        return Arrays.asList(matches);
    }
}
