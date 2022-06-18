package baseball.controller;

import static baseball.domain.Score.STRIKE;

import baseball.Computer;
import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.domain.Scorer;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;
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

    public void start() {
        boolean wantPlay = true;
        while (wantPlay) {
            play();
            outputView.startNewGame();
            wantPlay = inputView.startNewGame();
        }
    }

    // TODO: 여기 정리해라
    private void play() {
        final Scorer scorer = new Scorer(); // TODO
        final Balls computerBalls = computerBalls();
        boolean allStrikes = false;
        while (!allStrikes) {
            outputView.selectNumberRequest();
            final Balls playerBalls = playerBalls();
            final List<Score> scores = scorer.totalScoreTo(computerBalls, playerBalls);
            outputView.selectNumberResponse(scores);
            allStrikes = scores.containsAll(Arrays.asList(STRIKE, STRIKE, STRIKE)); // TODO
        }
        outputView.perfectScore();
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
