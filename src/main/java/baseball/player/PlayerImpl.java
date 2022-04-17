package baseball.player;

import baseball.parser.Parser;
import baseball.player.input.GameNumbers;
import baseball.player.input.GameProgressStatus;
import baseball.score.Score;
import baseball.view.View;

// TODO: 클래스명 별로임
public class PlayerImpl implements Player {

    private final View view;

    public PlayerImpl(View view) {
        this.view = view;
    }

    @Override
    public GameNumbers think() {
        return inputGameNumbers();
    }

    @Override
    public GameNumbers guess() {
        return inputGameNumbers();
    }

    private GameNumbers inputGameNumbers() {
        final String input = view.inputGameNumber();
        return Parser.asGameNumbers(input);
    }

    @Override
    public GameProgressStatus wantContinueNewGame() {
        final String input = view.inputContinueNewGame();
        return GameProgressStatus.fromString(input);
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
