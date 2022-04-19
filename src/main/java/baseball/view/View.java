package baseball.view;

import baseball.model.Score;

public interface View {

    String inputBalls();

    String inputContinueNewGame();

    void outputScoreMessage(Score score);

    void outputWinMessage();

    void outputContinueNewGameMessage();
}
