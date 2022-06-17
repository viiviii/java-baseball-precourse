package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScorerTest {

    private final Scorer scorer = new Scorer();

    @ParameterizedTest(name = "score: position={0}, number={1}")
    @CsvSource(value = {
            "0, 1, STRIKE",
            "0, 2, BALL",
            "0, 3, NOTHING"})
    void score(int position, int number, Score expected) {
        //given
        Balls balls = Balls.of(1, 2);
        Ball other = new Ball(position, number);

        //when
        Score actual = scorer.scoreTo(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "total score: balls=12, other={0}{1}")
    @CsvSource(value = {
            "1, 2, 3, STRIKE, STRIKE, STRIKE",
            "1, 2, 4, STRIKE, STRIKE, NOTHING",
            "2, 1, 4, BALL, BALL, NOTHING"
    })
    void totalScore(int number1, int number2, int number3, Score expected1, Score expected2, Score expected3) {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(number1, number2, number3);

        //when
        List<Score> scores = scorer.totalScoreTo(balls, other);

        //then
        assertThat(scores).containsExactlyInAnyOrder(expected1, expected2, expected3);
    }

    @ParameterizedTest(name = "strike: position={0}, number={1}")
    @CsvSource(value = {"0, 1, true", "0, 2, false", "1, 1, false"})
    void strike(int position, int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2);
        Ball other = new Ball(position, number);

        //when
        boolean actual = scorer.isStrike(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "ball: position={0}, number={1}")
    @CsvSource(value = {"0, 1, false", "0, 2, true", "1, 1, true"})
    void ball(int position, int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2);
        Ball other = new Ball(position, number);

        //when
        boolean actual = scorer.isBall(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}