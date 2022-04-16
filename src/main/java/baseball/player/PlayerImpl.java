package baseball.player;

import baseball.GameNumbers;
import baseball.parser.Parser;
import baseball.view.View;

// TODO: 클래스명 별로임
public class PlayerImpl implements Player {

    private final View view;

    public PlayerImpl(View view) {
        this.view = view;
    }

    @Override
    public void viewResult(String message) {
        view.output(message);
    }

    @Override
    public boolean wantContinueNewGame() {
        final String input = view.input();
        return isSelectNewGame(input);
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
        final String input = view.input();
        return Parser.asGameNumbers(input);
    }

    // TODO
    private boolean isSelectNewGame(String selectCode) {
        final String newGameStart = "1";
        final String exitApplication = "2";
        if (!(selectCode.equals(newGameStart) || selectCode.equals(exitApplication))) {
            throw new IllegalArgumentException();
        }
        return selectCode.equals(newGameStart);
    }
}
