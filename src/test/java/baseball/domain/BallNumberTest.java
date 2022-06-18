package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumberTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertDoesNotThrow(() -> new BallNumber(1));
        assertDoesNotThrow(() -> new BallNumber(9));
    }

    @DisplayName("값이 범위를 벗어나면 예외를 던진다")
    @Test
    void thrownExceptionWhenOutOfRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> new BallNumber(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new BallNumber(10));
    }

    @Test
    void equality() {
        //given
        int number = 1;
        int otherNumber = 2;

        //when
        BallNumber ballNumber = new BallNumber(number);
        BallNumber same = new BallNumber(number);
        BallNumber different = new BallNumber(otherNumber);

        //then
        assertThat(ballNumber)
                .isEqualTo(same).hasSameHashCodeAs(same)
                .isNotEqualTo(different).doesNotHaveSameHashCodeAs(different);
    }
}