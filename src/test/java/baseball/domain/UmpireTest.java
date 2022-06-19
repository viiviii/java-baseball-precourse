package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UmpireTest {

    private final Umpire umpire = new Umpire();

    @Test
    void allStrikes() {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(1, 2, 3);

        //when
        Scores scores = umpire.call(balls, other);

        //then
        assertThat(scores.strikeCount()).isEqualTo(3);
        assertThat(scores.ballCount()).isEqualTo(0);
    }

    @Test
    void allBalls() {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(3, 1, 2);

        //when
        Scores scores = umpire.call(balls, other);

        //then
        assertThat(scores.strikeCount()).isEqualTo(0);
        assertThat(scores.ballCount()).isEqualTo(3);
    }

    @Test
    void strikeAndBalls() {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(3, 2, 1);

        //when
        Scores scores = umpire.call(balls, other);

        //then
        assertThat(scores.strikeCount()).isEqualTo(1);
        assertThat(scores.ballCount()).isEqualTo(2);
    }
}