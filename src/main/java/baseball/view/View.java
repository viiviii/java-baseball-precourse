package baseball.view;

import baseball.score.Score;

public interface View {

    String inputGameNumber();

    String inputContinueNewGame();

    void outputScoreMessage(Score score);

    void outputWinMessage();

    void outputContinueNewGameMessage();
}
