package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    void strike() {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(1, 1);

        //when
        Hint hint = ball.matchOf(other);

        //then
        assertThat(hint).isEqualTo(Hint.STRIKE);
    }

    @Test
    void ball() {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(2, 1);

        //when
        Hint hint = ball.matchOf(other);

        //then
        assertThat(hint).isEqualTo(Hint.BALL);
    }

    @Test
    void nothing() {
        //given
        Ball ball = new Ball(1, 1);
        Ball other = new Ball(2, 2);

        //when
        Hint hint = ball.matchOf(other);

        //then
        assertThat(hint).isEqualTo(Hint.NOTHING);
    }

    @Test
    void equality() {
        //given
        int sameNumber = 1;
        int sameIndex = 3;

        //when
        Ball ball = new Ball(sameNumber, sameIndex);
        Ball other = new Ball(sameNumber, sameIndex);

        //then
        assertThat(ball).isEqualTo(other);
        assertThat(ball).hasSameHashCodeAs(other);
    }
}
