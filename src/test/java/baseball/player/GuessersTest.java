package baseball.player;

import baseball.io.Controller;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GuessersTest {

    @Test
    void guess() {
        //given
        Controller controller = mock(Controller.class);
        Guessers guessers = new Guessers(controller);

        String expected = "123";
        given(controller.input()).willReturn(expected);

        //when
        String guess = guessers.guess();

        //then
        assertThat(guess).isEqualTo(expected);
    }
}