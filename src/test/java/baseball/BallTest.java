package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// - 야구 숫자 만들기
//      - 1~9
//      - 서로 다른 수
class BallTest {

    @DisplayName("생성")
    @Test
    void create() throws Exception {
        assertDoesNotThrow(() -> new Ball(1));
        assertDoesNotThrow(() -> new Ball(9));
    }

    @ParameterizedTest(name = "숫자가 유효하지 않으면 예외를 던진다: value={0}")
    @ValueSource(ints = {0, 10})
    void thrownExceptionWhenOutOfRange(int value) throws Exception {
        //when
        Throwable thrown = catchThrowable(() -> new Ball(value));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
