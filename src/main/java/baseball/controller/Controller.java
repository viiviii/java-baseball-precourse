package baseball.controller;

import baseball.Balls;
import baseball.Computer;
import baseball.Score;
import baseball.Scorer;
import baseball.util.MyRandoms;
import baseball.view.InputView;
import java.util.List;

// TODO
public final class Controller {
    private final InputView inputView;
    private final MyRandoms randoms;

    public Controller(InputView inputView, MyRandoms randoms) {
        this.inputView = inputView;
        this.randoms = randoms;
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
        final Computer computer = new Computer(randoms); // TODO
        final List<Integer> computerBallNumbers = computer.randomBallNumbers();
        return Balls.of(computerBallNumbers);
    }
}
