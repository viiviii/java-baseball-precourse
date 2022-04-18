package baseball;

import baseball.player.ComputerPlayer;
import baseball.player.Player;
import baseball.player.PlayerImpl;
import baseball.view.ConsoleView;
import baseball.view.View;
import baseball.view.message.KoreanMessage;
import baseball.view.message.Message;

public class Application {
    public static void main(String[] args) {
        final Message message = new KoreanMessage();
        final View view = new ConsoleView(message);
        final Player player = new PlayerImpl(view);
        final Player computer = new ComputerPlayer();

        Game.Builder.initPlayers()
                .hostWith(computer)
                .guesserWith(player)
                .build()
                .start();
    }
}
