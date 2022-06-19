package baseball.domain;

import static baseball.domain.Score.BALL;
import static baseball.domain.Score.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoresTest {

    @ParameterizedTest(name = "스트라이크 갯수")
    @CsvSource(value = {"STRIKE, 1", "BALL, 0", "NOTHING, 0"})
    void strikeCount(Score score, int expected) {
        //given
        Scores scores = Scores.of(score);

        //when
        int actual = scores.strikeCount();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "스트라이크 갯수")
    @CsvSource(value = {"BALL, 1", "STRIKE, 0", "NOTHING, 0"})
    void ballCount(Score score, int expected) {
        //given
        Scores scores = Scores.of(score);

        //when
        int actual = scores.ballCount();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void equality() {
        //given
        Score score = STRIKE;
        Score otherScore = BALL;

        //when
        Scores scores = Scores.of(score);
        Scores same = Scores.of(score);
        Scores different = Scores.of(otherScore);

        //then
        assertThat(scores)
                .isEqualTo(same).hasSameHashCodeAs(same)
                .isNotEqualTo(different).doesNotHaveSameHashCodeAs(different);
    }
}
