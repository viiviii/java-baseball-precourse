package baseball.gamePlay;

import baseball.gameStrategy.Balls;
import java.util.List;

// TODO
public final class Controller {
    private final Player player;
    private final Computer computer;
    private final Umpire umpire;

    public Controller(Player player, Computer computer, Umpire umpire) {
        this.player = player;
        this.computer = computer;
        this.umpire = umpire;
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
