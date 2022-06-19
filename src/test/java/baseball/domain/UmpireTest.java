package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UmpireTest {

    private final Umpire umpire = new Umpire();

    @ParameterizedTest(name = "totalCalls: balls=123, other={0}{1}{2}")
    @CsvSource(value = {
            "1, 2, 3, STRIKE, STRIKE, STRIKE",
            "1, 2, 9, STRIKE, STRIKE, NOTHING",
            "2, 1, 9, BALL, BALL, NOTHING"
    })
    void totalCalls(int number1, int number2, int number3, Score expected1, Score expected2, Score expected3) {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(number1, number2, number3);

        //when
        List<Score> scores = umpire.totalCalls(balls, other).toList();

        //then
        assertThat(scores).containsExactlyInAnyOrder(expected1, expected2, expected3);
    }

    @ParameterizedTest(name = "call: balls=123, ball={0}")
    @CsvSource(value = {"1, STRIKE", "2, BALL", "9, NOTHING"})
    void call(int number, Score expected) {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Ball ball = new Ball(0, number);

        //when
        Score actual = umpire.call(balls, ball);

        //then
        assertThat(actual).isEqualTo(expected);
    }


    @ParameterizedTest(name = "strike: balls=123, ball={1}")
    @CsvSource(value = {"1, true", "2, false"})
    void strike(int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Ball other = new Ball(0, number);

        //when
        boolean actual = umpire.isStrike(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "ball: position={0}, number={1}")
    @CsvSource(value = {"0, 1, false", "0, 2, true", "1, 1, true"})
    void ball(int position, int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Ball other = new Ball(position, number);

        //when
        boolean actual = umpire.isBall(balls, other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

}