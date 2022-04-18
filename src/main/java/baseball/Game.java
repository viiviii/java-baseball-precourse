package baseball;

import baseball.player.Player;
import baseball.player.input.GameNumbers;
import baseball.player.input.GameProgressStatus;
import baseball.score.Score;
import baseball.score.ScoreMatcher;

import static baseball.player.input.GameProgressStatus.NEW_GAME_START;

public class Game {
    private final Player host;
    private final Player guesser;

    private Game(Player host, Player guesser) {
        this.host = host;
        this.guesser = guesser;
    }

    public void start() {
        boolean wantPlayGame = true;
        while (wantPlayGame) {
            playGame(host, guesser);
            guesser.announceContinueNewGame();
            final GameProgressStatus gameProgressStatus = guesser.wantContinueNewGame();
            wantPlayGame = gameProgressStatus.equals(NEW_GAME_START);
        }
    }

    private void playGame(Player host, Player guessers) {
        final GameNumbers gameNumbersOfHost = host.think();
        final ScoreMatcher scoreMatcher = ScoreMatcher.baseOn(gameNumbersOfHost);
        boolean isAllStrike = false;
        while (!isAllStrike) {
            final GameNumbers gameNumbersOfGuessers = guessers.guess();
            final Score score = scoreMatcher.scoreOf(gameNumbersOfGuessers);
            guessers.announceScore(score);
            isAllStrike = score.isAllStrike();
        }
        guessers.announceWin();
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
