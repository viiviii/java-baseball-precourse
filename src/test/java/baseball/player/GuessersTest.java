package baseball.player;

import baseball.GameNumbers;
import baseball.io.Controller;
import baseball.parser.Parser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GuessersTest {

    // TODO: 테스트가 이상해
    @Test
    void guess() {
        //given
        Controller controller = mock(Controller.class);
        Guessers guessers = new Guessers(controller);

        String input = "123";
        given(controller.input()).willReturn(input);
        GameNumbers expected = Parser.asGameNumbers(input);

        //when
        GameNumbers guess = guessers.guess();

        //then
        assertThat(guess).isEqualTo(expected);
    }
}