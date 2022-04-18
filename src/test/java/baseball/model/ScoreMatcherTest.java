package baseball.model;

import baseball.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseball.model.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreMatcherTest {

    private GameNumbers gameNumbers;
    private String baseNumber = "123";

    @BeforeEach
    void setUp() {
        this.gameNumbers = parseAsGameNumbers(baseNumber);
    }

    @Test
    void 같은_수가_전혀_없으면_낫싱이다() {
        //given
        String allNothingNumber = "456";
        GameNumbers other = parseAsGameNumbers(allNothingNumber);

        //when
        Score score = ScoreMatcher.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.isAllNothing()).isTrue();
        assertThat(score.getCount(NOTHING)).isEqualTo(3); // TODO: 하드코딩 제거
        assertThat(score.getCount(STRIKE)).isZero();
        assertThat(score.getCount(BALL)).isZero();
    }

    @Test
    void 같은_수가_모두_같은_자리에_있으면_올_스트라이크이다() {
        //given
        String allStrikeNumber = baseNumber;
        GameNumbers other = parseAsGameNumbers(allStrikeNumber);

        //when
        Score score = ScoreMatcher.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.isAllStrike()).isTrue();
        assertThat(score.getCount(STRIKE)).isEqualTo(3); // TODO: 하드코딩 제거
        assertThat(score.getCount(BALL)).isZero();
        assertThat(score.getCount(NOTHING)).isZero();

    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}스트라이크이다")
    @CsvSource(value = {
            "123, 3", // 1, 2, 3
            "129, 2", // 1, 2
            "189, 1", // 1
    })
    void 같은_수가_같은_자리에_있으면_스트라이크이다(String compare, int expectedCount) {
        //given
        GameNumbers other = parseAsGameNumbers(compare);

        //when
        Score score = ScoreMatcher.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.getCount(STRIKE)).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}볼이다")
    @CsvSource(value = {
            "231, 3", // 2, 3, 1
            "239, 2", // 2, 3
            "289, 1", // 2
    })
    void 같은_수가_다른_자리에_있으면_볼이다(String compare, int expectedCount) {
        //given
        GameNumbers other = parseAsGameNumbers(compare);

        //when
        Score score = ScoreMatcher.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.getCount(BALL)).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}볼 {2}스트라이크이다")
    @CsvSource(value = {
            "192, 1, 1", // ball="2", strike="1"
            "132, 2, 1", // ball=["2", "3"], strike="1"
    })
    void 볼과_스트라이트가_같이_있는_경우(String compare, int expectedBallCount, int expectedStrikeCount) {
        //given
        GameNumbers other = parseAsGameNumbers(compare);

        //when
        Score score = ScoreMatcher.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.getCount(BALL)).isEqualTo(expectedBallCount);
        assertThat(score.getCount(STRIKE)).isEqualTo(expectedStrikeCount);
    }

    private GameNumbers parseAsGameNumbers(String number) {
        return Parser.asGameNumbers(number);
    }
}
