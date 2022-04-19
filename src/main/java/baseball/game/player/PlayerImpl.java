package baseball.game.player;

import baseball.model.Balls;
import baseball.model.Score;
import baseball.model.SelectGameContinue;
import baseball.view.View;

public class PlayerImpl implements Player {
    private final View view;

    public PlayerImpl(View view) {
        this.view = view;
    }

    @Override
    public Balls think() {
        return inputBalls();
    }

    @Override
    public Balls guess() {
        return inputBalls();
    }

    private Balls inputBalls() {
        final String input = view.inputBalls();
        return Balls.fromString(input);
    }

    @Override
    public SelectGameContinue wantContinueWithNewGame() {
        final String input = view.inputContinueNewGame();
        return SelectGameContinue.fromString(input);
    }

    @Override
    public void announceContinueNewGame() {
        view.outputContinueNewGameMessage();
    }

    @Override
    public void announceWin() {
        view.outputWinMessage();
    }

    @Override
    public void announceScore(Score score) {
        view.outputScoreMessage(score);
    }
}
