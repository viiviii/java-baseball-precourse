package baseball.player;

import baseball.GameNumbers;
import baseball.Parser;
import baseball.io.Controller;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GuessersTest {

    @Test
    void guess() {
        //given
        Controller controller = mock(Controller.class);
        Guessers guessers = new Guessers(controller);

        String input = "123";
        given(controller.input()).willReturn(input);
        List<Integer> numbers = Parser.parseIntegerList(input);
        GameNumbers expected = new GameNumbers(numbers);

        //when
        GameNumbers guess = guessers.guess();

        //then
        assertThat(guess).isEqualTo(expected);
    }
}