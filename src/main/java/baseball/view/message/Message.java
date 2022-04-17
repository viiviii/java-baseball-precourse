package baseball.view.message;

import baseball.Hint;

public interface Message {

    String win();

    String continueNewGame();

    String inputGameNumbers();

    String hintName(Hint hint);
}
