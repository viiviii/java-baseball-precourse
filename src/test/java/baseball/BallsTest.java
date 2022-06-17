package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallsTest {

    @DisplayName("생성")
    @Test
    void create() {
        //given
        Ball firstBall = new Ball(0, 1);
        Ball secondBall = new Ball(1, 2);

        //when
        Balls balls = Balls.of(1, 2);

        //then
        assertThat(balls.hasSameBall(firstBall)).isTrue(); // TODO
        assertThat(balls.hasSameBall(secondBall)).isTrue(); // TODO
    }

    @ParameterizedTest(name = "위치와 숫자가 같은 볼이 있는지: position={0}, number={1}")
    @CsvSource(value = {"0, 1, true", "1, 2, true", "1, 1, false"})
    void contains(int position, int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2);
        Ball ball = new Ball(position, number);

        //when
        boolean actual = balls.hasSameBall(ball);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "숫자가 같은 볼이 있는지: position={0}, number={1}")
    @CsvSource(value = {"0, 1, true", "0, 2, true", "0, 3, false"})
    void hasSameNumber(int position, int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2);
        Ball ball = new Ball(position, number);

        //when
        boolean actual = balls.hasSameNumber(ball);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}