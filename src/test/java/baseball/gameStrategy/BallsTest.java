package baseball.gameStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

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
}