package baseball.player;

import baseball.GameNumbers;
import baseball.parser.Parser;
import baseball.view.View;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PlayerImplTest {

    // TODO: 테스트가 이상해
    @Test
    void guess() {
        //given
        View controller = mock(View.class);
        Player player = new PlayerImpl(controller);

        String input = "123";
        given(controller.input()).willReturn(input);
        GameNumbers expected = Parser.asGameNumbers(input);

        //when
        GameNumbers guess = player.guess();

        //then
        assertThat(guess).isEqualTo(expected);
    }
}