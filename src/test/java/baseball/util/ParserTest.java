package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @DisplayName("문자열을 integer list로_파싱한다")
    @Test
    void parseStringToIntegerList() {
        //given
        String value = "123";

        //when
        List<Integer> numbers = Parser.asIntegerList(value);

        //then
        assertThat(numbers).containsExactly(1, 2, 3);
    }
}
