package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GuessersTest {


    @Test
    void guessers는_값을_제출할_수_있다() {
        //given
        SomeOther someOther = new FakeSomeOther();
        Guessers guessers = new Guessers(someOther);

        //when
        Object guessValue = guessers.guess();

        //then
        assertThat(guessValue).isNotNull();
    }

    private static final class FakeSomeOther implements SomeOther {

        @Override
        public Object input() {
            return 1;
        }
    }
}