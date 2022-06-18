package baseball;

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
