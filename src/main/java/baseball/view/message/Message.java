package baseball.view.message;

import baseball.model.Hint;

public interface Message {

    String win();

    String continueNewGame();

    String inputBalls();

    String hintName(Hint hint);
}
