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
        List<Integer> numbers = Parser.asIntegerList(value);

        //then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 문자열를_게임숫자로_파싱할_수_없으면_IllegalArgumentException이_발생한다() {
        //given
        String str = "a1";

        //when
        Throwable thrown = catchThrowable(() -> Parser.asGameNumbers(str));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
