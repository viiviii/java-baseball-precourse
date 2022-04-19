package baseball.game;

import baseball.game.player.Player;
import baseball.model.Balls;
import baseball.model.Score;
import baseball.model.SelectGameContinue;

import static baseball.model.SelectGameContinue.NEW_GAME_START;

public class Game {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final int DIGITS = 3;

    private final Player host;
    private final Player guesser;

    private Game(Player host, Player guesser) {
        this.host = host;
        this.guesser = guesser;
    }

    public void start() {
        do {
            play();
            announceWin();
        } while (wantContinueWithNewGame());
    }

    private void play() {
        boolean isPerfectStrike = false;
        final Balls hostBalls = host.think();
        while (!isPerfectStrike) {
            final Balls guess = guesser.guess();
            final Score score = hostBalls.scoreOf(guess);
            isPerfectStrike = score.isPerfectStrike();
            guesser.announceScore(score);
        }
    }

    private void announceWin() {
        guesser.announceWin();
        guesser.announceContinueNewGame();
    }

    private boolean wantContinueWithNewGame() {
        final SelectGameContinue select = guesser.wantContinueWithNewGame();
        return select.equals(NEW_GAME_START);
    }

    public static final class Builder {
        private Player host;
        private Player guesser;

        private Builder() {
        }

        public static Builder initPlayers() {
            return new Builder();
        }

        public Builder hostWith(Player host) {
            this.host = host;
            return this;
        }

        public Builder guesserWith(Player guesser) {
            this.guesser = guesser;
            return this;
        }

        public Game build() {
            return new Game(host, guesser);
        }
    }
}
