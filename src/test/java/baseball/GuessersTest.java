package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GuessersTest {


    @Test
    void guessers는_값을_제출할_수_있다() {
        //given
        Guessers guessers = createGuessers();

        //when
        Object guessValue = guessers.guess();

        //then
        assertThat(guessValue).isNotNull();
    }

    private Guessers createGuessers() {
        return new FakeGuessers();
    }

    private static final class FakeGuessers implements Guessers {

        @Override
        public Object guess() {
            // 어떻게 테스트?
            String input = Console.readLine();
            return input;
        }
    }

}