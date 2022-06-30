package baseball.gameStrategy;

import static baseball.gameStrategy.Match.BALL;
import static baseball.gameStrategy.Match.NOTHING;
import static baseball.gameStrategy.Match.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @DisplayName("숫자가 같으면 true")
    @Test
    void isSameNumberReturnTrue() {
        //given
        int number = 1;

        Ball ball = new Ball(1, number);
        Ball other = new Ball(2, number);

        //when
        boolean actual = ball.isSameNumber(other);

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("숫자가 다르면 false")
    @Test
    void isSameNumberReturnFalse() {
        //given
        int number = 1;
        int otherNumber = 2;

        Ball ball = new Ball(1, number);
        Ball other = new Ball(1, otherNumber);

        //when
        boolean actual = ball.isSameNumber(other);

        //then
        assertThat(actual).isFalse();
    }

    @Test
    void strike() {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(1, 1);

        //when
        Match match = ball.matchOf(other);

        //then
        assertThat(match).isEqualTo(STRIKE);
    }

    @Test
    void ball() {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(2, 1);

        //when
        Match match = ball.matchOf(other);

        //then
        assertThat(match).isEqualTo(BALL);
    }

    @Test
    void nothing() {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(2, 2);

        //when
        Match match = ball.matchOf(other);

        //then
        assertThat(match).isEqualTo(NOTHING);
    }

    @Test
    void equalityReturnTrue() {
        //given
        int position = 1;
        int number = 1;

        //when
        Ball ball = new Ball(position, number);
        Ball same = new Ball(position, number);

        //then
        assertThat(ball).isEqualTo(same).hasSameHashCodeAs(same);
    }

    @Test
    void equalityReturnFalse() {
        //given
        int position = 1;
        int otherPosition = 2;

        int number = 1;
        int otherNumber = 2;

        //when
        Ball ball = new Ball(position, number);
        Ball differentPosition = new Ball(otherPosition, number);
        Ball differentNumber = new Ball(position, otherNumber);

        //then
        assertThat(ball)
                .isNotEqualTo(differentPosition).doesNotHaveSameHashCodeAs(differentPosition)
                .isNotEqualTo(differentNumber).doesNotHaveSameHashCodeAs(differentNumber);
    }
}
