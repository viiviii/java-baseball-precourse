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
    void create() {
        int position = 1;
        assertDoesNotThrow(() -> new Ball(position, 1));
        assertDoesNotThrow(() -> new Ball(position, 9));
    }

    @ParameterizedTest(name = "숫자가 유효하지 않으면 예외를 던진다: value={0}")
    @ValueSource(ints = {0, 10})
    void thrownExceptionWhenOutOfRange(int value) {
        //given
        int position = 1;

        //when
        Throwable thrown = catchThrowable(() -> new Ball(position, value));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equalityReturnTrue() {
        //given
        int position = 1;
        int number = 1;

        //when
        Ball ball = new Ball(position, number);
        Ball same = new Ball(position, number);

        //then
        assertThat(ball).isEqualTo(same).hasSameHashCodeAs(same);
    }

    @Test
    void equalityReturnFalse() {
        //given
        int position = 1;
        int otherPosition = 2;

        int number = 1;
        int otherNumber = 2;

        //when
        Ball ball = new Ball(position, number);
        Ball differentPosition = new Ball(otherPosition, number);
        Ball differentNumber = new Ball(position, otherNumber);

        //then
        assertThat(ball)
                .isNotEqualTo(differentPosition).doesNotHaveSameHashCodeAs(differentPosition)
                .isNotEqualTo(differentNumber).doesNotHaveSameHashCodeAs(differentNumber);
    }
}
