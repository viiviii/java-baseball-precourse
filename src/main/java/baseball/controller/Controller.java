package baseball.controller;

import baseball.Balls;
import baseball.Computer;
import baseball.Score;
import baseball.Scorer;
import baseball.view.InputView;
import java.util.List;

// TODO
public final class Controller {
    private final InputView inputView;
    private final Computer computer;

    public Controller(InputView inputView, Computer computer) {
        this.inputView = inputView;
        this.computer = computer;
    }

    public List<Score> compareTwoBalls() {
        final Balls computerBalls = computerBalls();
        final Balls playerBalls = playerBalls();
        final Scorer scorer = new Scorer(); // TODO
        return scorer.totalScoreTo(computerBalls, playerBalls);
    }

    private Balls playerBalls() {
        final List<Integer> playerBallNumbers = inputView.ballNumbers();
        return Balls.of(playerBallNumbers);
    }

    private Balls computerBalls() {
        final List<Integer> computerBallNumbers = computer.ballNumbers();
        return Balls.of(computerBallNumbers);
    }
}
