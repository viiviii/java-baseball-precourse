package baseball.game;

import baseball.game.player.Player;
import baseball.model.GameNumbers;
import baseball.model.GameProgressStatus;
import baseball.model.Score;
import baseball.model.SecretGameNumbers;

import static baseball.model.GameProgressStatus.NEW_GAME_START;

public class Game {
    private final Player host;
    private final Player guesser;

    private Game(Player host, Player guesser) {
        this.host = host;
        this.guesser = guesser;
    }

    public void start() {
        boolean wantPlay = true;
        while (wantPlay) {
            tryGuess();
            announceWin();
            wantPlay = isSelectNewGame();
        }
    }

    // TODO: 여기 변수명이랑 메서드명 잔뜩 이상함
    private void tryGuess() {
        boolean isAllStrike = false;
        // 호스트가 생각
        final SecretGameNumbers hostNumbers = host.think();
        while (!isAllStrike) {
            // 질문자가 추측
            final GameNumbers guess = guesser.guess();
            // 질문자의 점수와 비교
            final Score score = hostNumbers.matchOf(guess);
            // 점수 표시
            guesser.announceScore(score);
            // 점수 확인
            isAllStrike = score.isAllStrike();
        }
    }

    private void announceWin() {
        guesser.announceWin();
        guesser.announceContinueNewGame();
    }

    private boolean isSelectNewGame() {
        final GameProgressStatus select = guesser.wantContinueNewGame();
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
