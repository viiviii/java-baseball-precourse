package baseball.controller;

import baseball.Computer;
import baseball.domain.Balls;
import baseball.domain.Scores;
import baseball.domain.Umpire;
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
        final Umpire umpire = new Umpire(); // TODO
        final Balls computerBalls = computerBalls();
        boolean perfectScore = false;
        while (!perfectScore) {
            outputView.selectNumberRequest();
            final Balls playerBalls = playerBalls();
            final Scores scores = umpire.totalCalls(computerBalls, playerBalls);
            outputView.selectNumberResponse(scores.toList());
            perfectScore = scores.isPerfect(); // TODO
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
