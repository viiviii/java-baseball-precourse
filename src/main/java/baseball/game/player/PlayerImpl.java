package baseball.game.player;

import baseball.Parser;
import baseball.model.GameNumbers;
import baseball.model.Score;
import baseball.model.SecretGameNumbers;
import baseball.model.SelectGameContinue;
import baseball.view.View;

// TODO: 클래스명 별로임
public class PlayerImpl implements Player {

    private final View view;

    public PlayerImpl(View view) {
        this.view = view;
    }

    @Override
    public SecretGameNumbers think() {
        return SecretGameNumbers.from(inputGameNumbers());
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
