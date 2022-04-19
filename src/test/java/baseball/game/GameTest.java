package baseball.game;

import baseball.game.player.Player;
import baseball.model.Balls;
import baseball.model.SelectGameContinue;
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
        Balls hostThink = createBalls("123");
        Balls guess1 = createBalls("456");
        Balls guess2 = createBalls("129");

        given(host.think()).willReturn(hostThink);
        given(guesser.guess()).willReturn(guess1, guess2, hostThink);
        given(guesser.wantContinueWithNewGame()).willReturn(SelectGameContinue.EXIT_GAME);

        InOrder inOrder = inOrder(host, guesser);

        //when
        game.start();

        //then
        int guessCount = 3;
        inOrder.verify(host).think();
        inOrder.verify(guesser, times(guessCount)).guess();
        inOrder.verify(guesser).wantContinueWithNewGame();
    }

    private Balls createBalls(String str) {
        return Balls.fromString(str);
    }
}