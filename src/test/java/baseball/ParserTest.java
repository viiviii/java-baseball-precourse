package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ParserTest {

    @Test
    void 문자열을_integer_list로_파싱한다() {
        //given
        String value = "123";

        //when
        List<Integer> numbers = Parser.parseIntegerList(value);

        //then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 문자열를_integer_list로_파싱할_수_없으면_예외가_발생한다() {
        //given
        String value = "a1";

        //when
        Throwable thrown = catchThrowable(() -> Parser.parseIntegerList(value));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
