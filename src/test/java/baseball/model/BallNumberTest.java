package baseball.model;

import baseball.game.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class BallNumberTest {

    @DisplayName("유효한 경계 값 테스트")
    @Test
    void validRange() {
        //given
        int min = Game.START_NUMBER;
        int max = Game.END_NUMBER;

        //when
        Throwable minThrown = catchThrowable(() -> createBallNumber(min));
        Throwable maxThrown = catchThrowable(() -> createBallNumber(max));

        // then
        assertThat(minThrown).doesNotThrowAnyException();
        assertThat(maxThrown).doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 경계 값 테스트")
    @Test
    void invalidBoundaryValue() {
        //given
        int lessThanMin = Game.START_NUMBER - 1;
        int moreThanMax = Game.END_NUMBER + 1;

        //when
        Throwable lessThanMinThrown = catchThrowable(() -> createBallNumber(lessThanMin));
        Throwable moreThanMaxThrown = catchThrowable(() -> createBallNumber(moreThanMax));

        // then
        assertThat(lessThanMinThrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(moreThanMaxThrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equality() {
        //given
        int sameNumber = 1;

        //when
        BallNumber ballNumber = new BallNumber(sameNumber);
        BallNumber other = new BallNumber(sameNumber);

        //then
        assertThat(ballNumber).isEqualTo(other);
        assertThat(ballNumber).hasSameHashCodeAs(other);
    }

    private BallNumber createBallNumber(int i) {
        return new BallNumber(i);
    }
}
