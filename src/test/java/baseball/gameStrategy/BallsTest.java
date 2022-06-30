package baseball.gameStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.gamePlay.Score;
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
        Ball lastBall = new Ball(2, 3);

        //when
        Balls balls = Balls.of(1, 2, 3);

        //then
        assertThat(balls.toList()).containsExactly(firstBall, secondBall, lastBall);
    }

    @DisplayName("숫자가 3개가 아니면 예외를 던진다")
    @Test
    void thrownExceptionWhenNoThreeNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.of(1, 2));
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.of(1, 2, 3, 4));
    }

    @DisplayName("중복 값이 있으면 예외가 던져진다")
    @Test
    void thrownExceptionWhenDuplicateNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.of(1, 2, 1));
    }

    @ParameterizedTest(name = "위치와 숫자가 같은 볼이 있는지: position={0}, number={1}")
    @CsvSource(value = {"0, 1, true", "1, 2, true", "1, 1, false"})
    void hasSameBall(int position, int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Ball ball = new Ball(position, number);

        //when
        boolean actual = balls.hasSameBall(ball);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "숫자가 같은 볼이 있는지: position={0}, number={1}")
    @CsvSource(value = {"0, 1, true", "0, 2, true", "0, 9, false"})
    void hasSameNumber(int position, int number, boolean expected) {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Ball ball = new Ball(position, number);

        //when
        boolean actual = balls.hasSameNumber(ball);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void allStrikes() {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(1, 2, 3);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.strikeCount()).isEqualTo(3);
        assertThat(score.ballCount()).isEqualTo(0);
    }

    @Test
    void allBalls() {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(3, 1, 2);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.strikeCount()).isEqualTo(0);
        assertThat(score.ballCount()).isEqualTo(3);
    }

    @Test
    void strikeAndBalls() {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(3, 2, 1);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.strikeCount()).isEqualTo(1);
        assertThat(score.ballCount()).isEqualTo(2);
    }
}