package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    @Test
    void 문자열을_integer_list로_파싱한다() {
        //given
        String value = "123";

        //when
        List<Integer> numbers = Parser.asIntegerList(value);

        //then
        assertThat(numbers).containsExactly(1, 2, 3);
    }
}
