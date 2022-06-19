package baseball.controller;

import baseball.Computer;
import baseball.domain.Balls;
import baseball.domain.Umpire;
import baseball.view.Player;
import java.util.List;

// TODO
public final class Controller {
    private final Player player;
    private final Computer computer;

    public Controller(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void start() {
        boolean wantPlay = true;
        while (wantPlay) {
            play();
            wantPlay = player.guessStartNewGame();
        }
    }

    // TODO: 여기 정리해라
    private void play() {
        final Umpire umpire = new Umpire(); // TODO
        final Balls computerBalls = computerBalls();
        boolean perfectScore = false;
        while (!perfectScore) {
            final Balls playerBalls = playerBalls();
            final Score score = umpire.call(computerBalls, playerBalls);
            player.announceScore(score);
            perfectScore = isPerfect(score);
        }
    }

    private boolean isPerfect(Score score) {
        return score.strikeCount() == 3; // TODO: 상수
    }

    private Balls playerBalls() {
        // TODO: Balls 자체를 반환하도록
        final List<Integer> playerBallNumbers = player.guessBalls();
        return Balls.of(playerBallNumbers);
    }

    private Balls computerBalls() {
        final List<Integer> computerBallNumbers = computer.ballNumbers();
        return Balls.of(computerBallNumbers);
    }
}
