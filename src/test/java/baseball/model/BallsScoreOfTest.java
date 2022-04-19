package baseball.model;

import baseball.game.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BallsScoreOfTest {
    private String baseNumbers = "123";
    private Balls balls = createBalls(baseNumbers);

    @DisplayName("같은 수가 전혀 없으면 낫싱이다")
    @Test
    void nothing() {
        //given
        String allNothingNumbers = "456";
        Balls other = createBalls(allNothingNumbers);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.isNothing()).isTrue();
        assertThat(score.getStrike()).isZero();
        assertThat(score.getBall()).isZero();
    }

    @DisplayName("같은 수가 모두 같은 자리에 있으면 올 스트라이크이다")
    @Test
    void allStrike() {
        //given
        String allStrikeNumbers = baseNumbers;
        Balls other = createBalls(allStrikeNumbers);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.isPerfectStrike()).isTrue();
        assertThat(score.getStrike()).isEqualTo(Game.DIGITS);
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}스트라이크이다")
    @CsvSource(value = {
            "123, 3", // 1, 2, 3
            "129, 2", // 1, 2
            "189, 1", // 1
    })
    void strikeCount(String compare, int expectedCount) {
        //given
        Balls other = createBalls(compare);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.getStrike()).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}볼이다")
    @CsvSource(value = {
            "231, 3", // 2, 3, 1
            "239, 2", // 2, 3
            "289, 1", // 2
    })
    void ballCount(String compare, int expectedCount) {
        //given
        Balls other = createBalls(compare);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.getBall()).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}볼 {2}스트라이크이다")
    @CsvSource(value = {
            "192, 1, 1", // ball="2", strike="1"
            "132, 2, 1", // ball=["2", "3"], strike="1"
    })
    void countBothBallAndStrike(String compare, int expectedBallCount, int expectedStrikeCount) {
        //given
        Balls other = createBalls(compare);

        //when
        Score score = balls.scoreOf(other);

        //then
        assertThat(score.getBall()).isEqualTo(expectedBallCount);
        assertThat(score.getStrike()).isEqualTo(expectedStrikeCount);
    }

    private Balls createBalls(String number) {
        return Balls.fromString(number);
    }
}
