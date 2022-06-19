package baseball.domain;

import static baseball.domain.Score.BALL;
import static baseball.domain.Score.NOTHING;
import static baseball.domain.Score.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoresTest {

    @DisplayName("모든 점수가 STRIKE면 true")
    @Test
    void perfectScore() {
        //given
        Scores scores = Scores.of(STRIKE, STRIKE, STRIKE);

        //when
        boolean actual = scores.isPerfect();

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("모든 점수가 STRIKE가 아니면 false")
    @Test
    void notPerfectScore() {
        //given
        Scores scores = Scores.of(STRIKE, BALL, NOTHING);

        //when
        boolean actual = scores.isPerfect();

        //then
        assertThat(actual).isFalse();
    }
}
