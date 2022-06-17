package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScorerTest {

    private final Scorer scorer = new Scorer();

    @ParameterizedTest(name = "score: position={0}, expected={1}")
    @CsvSource(value = {"1, true", "2, false", "3, false"})
    void strike(int position, boolean expected) {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(position, 1);

        //when
        boolean actual = scorer.isStrike(ball, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "ball: position={0}, expected={1}")
    @CsvSource(value = {"1, false", "2, true", "3, true"})
    void ball(int position, boolean expected) {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(position, 1);

        //when
        boolean actual = scorer.isBall(ball, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "score: position={0}, number={1}, expected={2}")
    @CsvSource(value = {
            "1, 1, 스트라이크",
            "2, 1, 볼",
            "2, 2, 낫싱"})
    void score(int position, int number, String expected) {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(position, number);

        //when
        String actual = scorer.scoreTo(ball, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}