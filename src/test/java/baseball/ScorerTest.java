package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScorerTest {

    private final Scorer scorer = new Scorer();

    @ParameterizedTest(name = "score: position={0}, number={1}, expected={2}")
    @CsvSource(value = {
            "1, 1, STRIKE",
            "1, 2, BALL",
            "1, 3, NOTHING"})
    void score(int position, int number, Score expected) {
        //given
        List<Ball> balls = createBalls(1, 2); // 12
        Ball other = new Ball(position, number);

        //when
        Score actual = scorer.scoreTo(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "strike: position={0}, number={1}, expected={2}")
    @CsvSource(value = {"1, 1, true", "1, 2, false", "2, 1, false"})
    void strike(int position, int number, boolean expected) {
        //given
        List<Ball> balls = createBalls(1, 2);
        Ball other = new Ball(position, number);

        //when
        boolean actual = scorer.isStrike(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "ball: position={0}, number={1}, expected={2}")
    @CsvSource(value = {"1, 1, false", "1, 2, true", "2, 1, true"})
    void ball(int position, int number, boolean expected) {
        //given
        List<Ball> balls = createBalls(1, 2);
        Ball other = new Ball(position, number);

        //when
        boolean actual = scorer.isBall(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "hasSameNumber: position={0}, number={1}, expected={2}")
    @CsvSource(value = {"1, 1, true", "1, 2, true", "1, 3, false"})
    void hasSameNumber(int position, int number, boolean expected) {
        //given
        List<Ball> balls = createBalls(1, 2);
        Ball other = new Ball(position, number);

        //when
        boolean actual = scorer.hasSameNumber(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    private List<Ball> createBalls(int number1, int number2) {
        Ball ball1 = new Ball(1, number1);
        Ball ball2 = new Ball(2, number2);
        return Arrays.asList(ball1, ball2);
    }
}