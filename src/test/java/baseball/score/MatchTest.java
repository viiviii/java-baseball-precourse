package baseball.score;

import baseball.GameNumbers;
import baseball.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static baseball.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {

    private GameNumbers gameNumbers;

    @BeforeEach
    void setUp() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3);
        gameNumbers = new GameNumbers(numbers);
    }

    @Test
    void 같은_수가_전혀_없으면_낫싱을_리턴한다() {
        //given
        String allDifferenceNumbers = "456";
        GameNumbers other = parseAsGameNumbers(allDifferenceNumbers);

        //when
        Score score = Match.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.isNothing()).isTrue();
        assertThat(score.get(NOTHING)).isEqualTo(3); // TODO: 하드코딩 제거
        assertThat(score.get(STRIKE)).isZero();
        assertThat(score.get(BALL)).isZero();
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}스트라이크이다")
    @CsvSource(value = {
            "123, 3", // 1, 2, 3
            "129, 2", // 1, 2
            "189, 1", // 1
    })
    void 같은_수가_같은_자리에_있으면_스트라이크를_리턴한다(String compare, int expectedCount) {
        //given
        GameNumbers other = parseAsGameNumbers(compare);

        //when
        Score score = Match.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.get(STRIKE)).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}볼이다")
    @CsvSource(value = {
            "231, 3", // 2, 3, 1
            "239, 2", // 2, 3
            "289, 1", // 2
    })
    void 같은_수가_다른_자리에_있으면_볼을_리턴한다(String compare, int expectedCount) {
        //given
        GameNumbers other = parseAsGameNumbers(compare);

        //when
        Score score = Match.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.get(BALL)).isEqualTo(expectedCount);
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
        Score score = Match.baseOn(gameNumbers).scoreOf(other);

        //then
        assertThat(score.get(BALL)).isEqualTo(expectedBallCount);
        assertThat(score.get(STRIKE)).isEqualTo(expectedStrikeCount);
    }

    private GameNumbers parseAsGameNumbers(String number) {
        return Parser.asGameNumbers(number);
    }
}
