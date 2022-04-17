package baseball;

import baseball.player.ComputerPlayer;
import baseball.player.Player;
import baseball.player.PlayerImpl;
import baseball.score.Match;
import baseball.score.Score;
import baseball.view.ConsoleView;
import baseball.view.View;
import baseball.view.message.KoreanMessage;
import baseball.view.message.Message;

public class Application {
    public static void main(String[] args) {
        // TODO: 테스트 추가
        final Message message = new KoreanMessage();
        final View view = new ConsoleView(message);
        final Player host = new ComputerPlayer();
        final Player guessers = new PlayerImpl(view);

        boolean wantPlayGame = true;
        while (wantPlayGame) {
            playGame(host, guessers);
            guessers.announceContinueNewGame();
            wantPlayGame = guessers.wantContinueNewGame();
        }
    }

    // TODO: 클래스로 분리
    private static void playGame(Player host, Player guessers) {
        final GameNumbers gameNumbersOfHost = host.think();
        final Match match = Match.baseOn(gameNumbersOfHost);
        boolean isAllStrike = false;
        while (!isAllStrike) {
            final GameNumbers gameNumbersOfGuessers = guessers.guess();
            final Score score = match.scoreOf(gameNumbersOfGuessers);
            guessers.announceScore(score);
            isAllStrike = score.isAllStrike();
        }
        guessers.announceWin();
    }
}
