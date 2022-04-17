package baseball.view.message;

import baseball.Hint;

public interface Message {

    String win();

    String continueNewGame();

    String hintName(Hint hint);
}
