package baseball.gameStrategy;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.gamePlay.Score;
import baseball.gamePlay.Umpire;
import org.junit.jupiter.api.Test;

class UmpireTest {

    private final Umpire umpire = new UmpireImpl();

    @Test
    void allStrikes() {
        //given
        Balls balls = Balls.of(1, 2, 3);
        Balls other = Balls.of(1, 2, 3);

        //when
        Score score = umpire.call(balls, other);

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
        Score score = umpire.call(balls, other);

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
        Score score = umpire.call(balls, other);

        //then
        assertThat(score.strikeCount()).isEqualTo(1);
        assertThat(score.ballCount()).isEqualTo(2);
    }
}