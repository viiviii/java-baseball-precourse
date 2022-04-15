package baseball;

import baseball.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkerTest {

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
        List<Integer> other = parse(allDifferenceNumbers);
        GameNumbers otherGameNumbers = new GameNumbers(other);

        //when
        Score score = Marker.origin(gameNumbers).compareWith(otherGameNumbers);

        //then
        assertThat(score.isNothing()).isTrue();
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}스트라이크이다")
    @CsvSource(value = {
            "123, 3", // 1, 2, 3
            "129, 2", // 1, 2
            "189, 1", // 1
    })
    void 같은_수가_같은_자리에_있으면_스트라이크를_리턴한다(String compare, int expectedCount) {
        //given
        List<Integer> other = parse(compare);
        GameNumbers otherGameNumbers = new GameNumbers(other);

        //when
        Score score = Marker.origin(gameNumbers).compareWith(otherGameNumbers);

        //then
        assertThat(score.get(HintStatus.STRIKE)).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "[{index}] 123과 {0}는 {1}볼이다")
    @CsvSource(value = {
            "231, 3", // 2, 3, 1
            "239, 2", // 2, 3
            "289, 1", // 2
    })
    void 같은_수가_다른_자리에_있으면_볼을_리턴한다(String compare, int expectedCount) {
        //given
        List<Integer> other = parse(compare);
        GameNumbers otherGameNumbers = new GameNumbers(other);

        //when
        Score score = Marker.origin(gameNumbers).compareWith(otherGameNumbers);

        //then
        assertThat(score.get(HintStatus.BALL)).isEqualTo(expectedCount);
    }

    // TODO: 이제 메시지랑 분리되었으니 테스트 케이스 보강
    @Test
    void 볼과_스트라이트가_같이_있는_경우() {
        //given
        String oneStrikeOneBall = "192"; // "1" is strike, "2" is ball
        List<Integer> other = parse(oneStrikeOneBall);
        GameNumbers otherGameNumbers = new GameNumbers(other);

        //when
        Score score = Marker.origin(gameNumbers).compareWith(otherGameNumbers);

        //then
        assertThat(score.get(HintStatus.BALL)).isEqualTo(1);
        assertThat(score.get(HintStatus.STRIKE)).isEqualTo(1);
    }

    private List<Integer> parse(String number) {
        return Parser.parseIntegerList(number);
    }
}
