package baseball.controller;

import baseball.Balls;
import baseball.Computer;
import baseball.Score;
import baseball.Scorer;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

// TODO
public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public Controller(InputView inputView, OutputView outputView, Computer computer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
    }

    public void play() {
        outputView.selectNumberRequest();
        final List<Score> scores = compareTwoBalls();
        outputView.selectNumberResponse(scores);
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
