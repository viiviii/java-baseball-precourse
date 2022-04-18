package baseball;

import baseball.parser.Parser;
import baseball.player.Player;
import baseball.player.input.GameNumbers;
import baseball.player.input.GameProgressStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class GameTest {
    private Player host = mock(Player.class);
    private Player guesser = mock(Player.class);
    private Game game = Game.Builder.initPlayers()
            .hostWith(host)
            .guesserWith(guesser)
            .build();

    @Test
    void start() {
        //given
        GameNumbers hostThink = parseAsGameNumbers("123");
        GameNumbers guess1 = parseAsGameNumbers("456");
        GameNumbers guess2 = parseAsGameNumbers("129");

        given(host.think()).willReturn(hostThink);
        given(guesser.guess()).willReturn(guess1, guess2, hostThink);
        given(guesser.wantContinueNewGame()).willReturn(GameProgressStatus.EXIT_APPLICATION);

        InOrder inOrder = inOrder(host, guesser);

        //when
        game.start();

        //then
        int guessCount = 3;
        inOrder.verify(host).think();
        inOrder.verify(guesser, times(guessCount)).guess();
        inOrder.verify(guesser).wantContinueNewGame(); // TODO: wantContinueNewGame 메서드명 이상함 select?
    }

    private GameNumbers parseAsGameNumbers(String number) {
        return Parser.asGameNumbers(number);
    }
}