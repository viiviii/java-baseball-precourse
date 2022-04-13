package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GuessersTest {


    @Test
    void guessers는_값을_제출할_수_있다() {
        //given
        SomeOther someOther = mock(SomeOther.class);
        Guessers guessers = new FakeGuessers(someOther);
        given(someOther.input()).willReturn(1);

        //when
        Object guessValue = guessers.guess();

        //then
        assertThat(guessValue).isNotNull();
    }


    private static final class FakeGuessers implements Guessers {

        private final SomeOther someOtherClass;

        FakeGuessers(SomeOther someOtherClass) {
            this.someOtherClass = someOtherClass;
        }

        @Override
        public Object guess() {
            return someOtherClass.input();
        }
    }

    private static final class SomeOther {

        public Object input() {
            return null;
        }
    }
}